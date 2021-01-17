package workshop.account.entity;

public class Account {
	private String custId;
	private String acctId;
	private int balance;
	public Account (String custId, String acctId, int balance){
		this.custId = custId;
		this.acctId = acctId;
		this.balance = balance;
	}
	
	void setBalance(int newBalance){
		this.balance = newBalance;
	}
	int getBalance() {
		return balance;
	}
	void setCustId(String newCustId){
		this.custId = newCustId;
	}
	String getCustId() {
		return custId;
	}
	void setAcctId(String newAcctId){
		this.acctId = newAcctId;
	}
	public String getAcctId() {
		return acctId;
	}
	public void deposit(int amount){
		this.balance += amount;
	}
	public void withdraw(int amount) {
		this.balance -= amount;
	}
	
	@Override
	public String toString() {
		return "-----------------------"+
				"\n사용자번호: "+custId+
				"\n계좌번호: "+ acctId+
				"\n잔액:"+balance+
				"\n-----------------------";
	}
}
