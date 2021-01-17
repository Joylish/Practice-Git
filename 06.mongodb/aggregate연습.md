# Aggregation 연습

#### 사전 준비

* maven project에서 zip.json을 mongoDB에 insert했다.

```java
package mymongo.myjava.zips;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.BulkWriteOptions;
import com.mongodb.client.model.InsertOneModel;

public class ZipsJsonToDB {
	public static void main(String[] args) {
		MongoClient client = new MongoClient("localhost", 27017);
		MongoDatabase database = client.getDatabase("zips_db");
		MongoCollection<Document> collection = database.getCollection("zips_col");
		System.out.println(client);
		System.out.println(database);
		System.out.println(collection);
		
		int count = 0;
		int batch = 1000;

		List<InsertOneModel<Document>> docs = new ArrayList<>();
		
		try {
			// 버퍼사이즈만큼 차면 db에 넣는 작업 실행
			BufferedReader br = new BufferedReader(new FileReader("zip.json"));
			String line;
		      while ((line = br.readLine()) != null) {
		         docs.add(new InsertOneModel<>(Document.parse(line)));
		         count++;
		         if (count == batch) {
		           collection.bulkWrite(docs, new BulkWriteOptions().ordered(false));
		           docs.clear();
		           count = 0;
		        }
		    }
		      if (count > 0) {
				   collection.bulkWrite(docs, new BulkWriteOptions().ordered(false));
				}  
		      br.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}

```



zip_col의 컬렉션은 다음과 같다.

![image-20200828161926196](C:\Users\IMPlay\Desktop\TIL\images\mongodb\exampleData-zip.png)



### 연습시작!

Datagrip IDE mongodb console에서 zips_db로 switch해주었다.

```sql
use zips_db
```

![image-20200828162510063](C:\Users\IMPlay\Desktop\TIL\images\mongodb\datagrip.png)



Q1. SQL: **SELECT COUNT(*) AS count FROM zip**

```sql
db.zips_col.aggregate([
    {
        $group: {
            _id: null,
            total_pop: {$sum: 1}
        }
    }
])
```

Q2. SQL: **SELECT SUM(pop) as total_pop AS count FROM zip** 

```sql
db.zips_col.aggregate([
    {
        $group: {
            _id: null,
            total_pop: {$sum: "$pop"}
        }
    }
])
```



Q3. SQL: **SELECT state, SUM(pop) as total_pop FROM zip GROUP BY state**

```sql
db.zips_col.aggregate([
    {
        $group: {
            _id: "$state",
            total_pop: {$sum: "$pop"}
        }
    }
])
```



Q4. SQL : **select city, sum(pop) as total_pop from zip group by city**

```sql
db.zips_col.aggregate([
    {
        $group: {
            _id: "$city",
            total_pop: {$sum: "$pop"}
        }
    }
])
```



Q5. SQL: **SELECT state, SUM(pop) as total_pop FROM zip GROUP BY state ORDER BY as total_pop**

```sql
db.zips_col.aggregate([
    {
        $group: {
            _id: "$state",
            total_pop: {$sum: "$pop"}
        }
    },
    {
        $sort : { total_pop: 1 }
    }
])
```



Q6. SQL: **SELECT COUNT(*) FROM zip WHERE state = 'MA'**

```sql
db.zips_col.aggregate([
    {$match: { state: "MA"}},
    {
        $group: {
            _id: null,
           count: {$sum: 1}
        }
    },
])
```



Q7. **select state,sum(pop) as total_pop from zip where state = 'MA' group by state**

```sql
db.zips_col.aggregate([
    {$match: { state: "MA"}},
    {
        $group: {
           _id: "$state",
           total_pop: {$sum: "$pop"}
        }
    },
])
```



Q7.1 **select city,sum(pop) as total_pop from zip where state in 'MA' group by state**

```sql
db.zips_col.aggregate([
    {$match: { state: "MA"}},
    {
        $group: {
           _id: "$city",
           total_pop: {$sum: "$pop"}
        }
    },
])
```

Q7.2 s**elect state,sum(pop) as total_pop from zip where state in ('DE', 'MS') group by state**

```sql
db.zips_col.aggregate([
    {$match: { state: {$in:["DE","MS"]}}},
    {
        $group: {
           _id: "$state",
           total_pop: {$sum: "$pop"}
        }
    },
])
```

Q8. **SELECT state, SUM(pop) as total_pop FROM zip GROUP BY state HAVING SUM(pop) > 10000000**

```sql
db.zips_col.aggregate([
    {
        $group: {
           _id: "$state",
           total_pop: {$sum: "$pop"}
        }
    },
    {$match: { total_pop: {$gt:10000000}}},
])
```

Q9.**1000만 이상의 state 별 총 인구를 state_pop 필드명으로 출력하고 _id는 출력하지 않기_**

```sql
db.zips_col.aggregate([
    {
        $group: {
           _id: "$state",
           state_pop: {$sum: "$pop"}
        }
    },
    {$match: { state_pop: {$gt:10000000}}},
    { $unset: ["_id"]}
])
```

Q10.**1000만 이상의 state만 내림차순 정렬하여 3개만 가져오기**

```sql
db.zips_col.aggregate([
    {
        $group: {
           _id: "$state",
           state_pop: {$sum: "$pop"}
        }
    },
    {$match: { state_pop: {$gt:10000000}}},
    {
        $sort : { total_pop: 1 }
    },
    { $limit: 3 }
])
```

Q11.**1000만 이상의 state 별 총 인구를 state_pop 필드명으로 출력하고, _id는 출력하지 않으며, 가장 많은 인구를 가진 3개만 출력하기**

```sql
db.zips_col.aggregate([
    {
        $group: {
           _id: "$state",
           state_pop: {$sum: "$pop"}
        }
    },
    {$match: { state_pop: {$gt:10000000}}},
    {
        $sort : { state_pop: -1 }
    },
    { $unset: ["_id"]},
    { $limit: 3 }
])
```

Q12. **select state, city, sum(pop) as total_pop from zip group by state,city**

```sql
db.zips_col.aggregate([
    {
        $group: {
           _id: {
                state:"$state",
                city:"$city"
           },
           total_pop: {$sum: "$pop"}
        }
    },
    {
        $sort : { total_pop: -1 }
    },
    { $unset: ["_id"]},
    { $limit: 3 }
])
```



Q13. **select state, city, sum(pop) as total_pop from zip GROUP BY state, city HAVING city = 'POINT BAKER'**

```sql
db.zips_col.aggregate([
    {
        $group: {
           _id: {
                state:"$state",
                city:"$city"
           },
           total_pop: {$sum: "$pop"}
        }
    },
    {$match: { city: 'POINT BAKER'}},
    {
        $sort : { total_pop: -1 }
    },
    { $unset: ["_id"]},
    { $limit: 3 }
])
```



Q14. **SELECT AVG(pop) FROM zip GROUP BY state, city**

```sql
db.zips_col.aggregate([
    {
        $group: {
           _id: {
                state:"$state",
                city:"$city"
           },
           avg_pop: {$avg: "$pop"}
        }
    },
    { $unset: ["_id"]},
])

```



Q15. **select state,city, avg(pop) as avg_pop from zip GROUP BY state, city having avg_pop > 30000**

```sql
db.zips_col.aggregate([
    {
        $group: {
           _id: {
                state:"$state",
                city:"$city"
           },
           avg_pop: {$avg: "$pop"}
        }
    },
    { $unset: ["_id"]},
    {$match: { avg_pop: {$gt:30000}}},

])
```



Q16 **주별 도시 인구 평균이 30000 이 넘는 곳의 state 와 city 이름만 출력하고 평균을 출력하지 않기 (3개만 출력하기)**

```sql
db.zips_col.aggregate([
    {
        $group: {
           _id: {
                state:"$state",
                city:"$city"
           },
           avg_pop: {$avg: "$pop"}
        }
    },
    {$match: { avg_pop: {$gt:30000}}},
    {$project: {_id:1, avg_pop:0}},
    { $limit: 3 },
])
```