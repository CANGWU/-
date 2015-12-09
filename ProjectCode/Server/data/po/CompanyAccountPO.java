package po;

public class CompanyAccountPO {
	String customer;
	String agency;
	String people;
	String stock;
	String bankaccount;
	
	public CompanyAccountPO(String customer, String agency, String people, String stock, String bankaccount){
		this.customer = customer;
		this.agency = agency;
		this.people = people;
		this.stock = stock;
		this.bankaccount = bankaccount;
	}
	
	public String getCustomer() {
		return customer;
	}
	public void setCustomer(String customer) {
		this.customer = customer;
	}
	public String getAgency() {
		return agency;
	}
	public void setAgency(String agency) {
		this.agency = agency;
	}
	public String getPeople() {
		return people;
	}
	public void setPeople(String people) {
		this.people = people;
	}
	public String getStock() {
		return stock;
	}
	public void setStock(String stock) {
		this.stock = stock;
	}
	public String getBankaccount() {
		return bankaccount;
	}
	public void setBankaccount(String bankaccount) {
		this.bankaccount = bankaccount;
	}
}