package com.costuary.constant;

public class SqlConstant {

	public final static String COL_SEQ = "SEQ";
	public final static String COL_DATE = "DATE";
	public final static String COL_TYPE = "TYPE";
	public final static String COL_SUBCAT = "SUBCAT";
	public final static String COL_COMMENT = "COMMENT";
	public final static String COL_AMT = "AMT";
	public final static String COL_CURRENCY = "CURRENCY";

	public static String getSubCatCn(int subCatId){
		return SubCatCn.getName(subCatId);
	}

	public static int getSubCatId(String subCatEn){
		return SubCatEn.getId(subCatEn);
	}

	public static int getTypeId(String typeEn){
		return TypeEn.getId(typeEn);
	}

	public static int getCurrencyId(String currencyEn){
		return CurrencyEn.getId(currencyEn);
	}

	public enum CurrencyEn{
		RMB("RMB",101),
		JPY("JPY",102),
		USD("USD",1033)
		;
		private String curencyEn;
		private int curencyId;
		private CurrencyEn(String curencyEn,int curencyId){
			this.curencyEn = curencyEn;
			this.curencyId = curencyId;
		}
		public static String getName(int curencyId){
			for(CurrencyEn s : CurrencyEn.values()){
				if(s.getcurencyId() == curencyId){
					return s.getcurencyEn();
				}
			}
			return null;
		}
		public static int getId(String curencyEn){
			for(CurrencyEn s : CurrencyEn.values()){
				if(s.getcurencyEn().equals(curencyEn)){
					return s.getcurencyId();
				}
			}
			return 0;
		}
		public String getcurencyEn() {
			return curencyEn;
		}
		public void setcurencyEn(String curencyEn) {
			this.curencyEn = curencyEn;
		}
		public int getcurencyId() {
			return curencyId;
		}
		public void setcurencyId(int curencyId) {
			this.curencyId = curencyId;
		}
	}

	public enum TypeEn{
		Expense("Expense",1),
		Income("Income",2)
		;
		private String typeEn;
		private int typeId;

		private TypeEn(String typeEn,int typeId){
			this.typeEn = typeEn;
			this.typeId = typeId;
		}
		public static String getName(int typeId){
			for(TypeEn s : TypeEn.values()){
				if(s.getTypeId() == typeId){
					return s.getTypeEn();
				}
			}
			return null;
		}
		public static int getId(String typeEn){
			for(TypeEn s : TypeEn.values()){
				if(s.getTypeEn().equals(typeEn)){
					return s.getTypeId();
				}
			}
			return 0;
		}
		public String getTypeEn() {
			return typeEn;
		}
		public void setTypeEn(String typeEn) {
			this.typeEn = typeEn;
		}
		public int getTypeId() {
			return typeId;
		}
		public void setTypeId(int typeId) {
			this.typeId = typeId;
		}
	}


	public enum SubCatCn{
		General("通用",100),
		Food("食品",101),
		Drinks("饮品",102),
		Croceries("杂物",103),
		Shopping("购物",104),
		Personal("个人",105),
		Entertain("娱乐",106),
		Movies("电影",107),
		Social("社交",108),
		Transport("交通",109),
		AppStore("应用商店",110),
		Mobile("话费",111),
		Computer("电脑",112),
		Gifts("礼物",113),
		Housing("居家",114),
		Travel("旅游",115),
		Tickets("门票",116),
		Books("书籍",117),
		Medical("医疗",118),
		Transfer("转账",119),
		Insurance("保险",120),
		Utilities("水电煤",121),
		Rent("房租",122);
		private String subCatCn;
		private int subCatId;
		private SubCatCn(String subCatCn,int subCatId){
			this.subCatCn = subCatCn;
			this.subCatId = subCatId;
		}
		public static String getName(int subCatId){
			for(SubCatCn s : SubCatCn.values()){
				if(s.getSubCatId() == subCatId){
					return s.subCatCn;
				}
			}
			return null;
		}
		public static int getId(String subCatCn){
			for(SubCatCn s : SubCatCn.values()){
				if(s.getSubCatCn().equals(subCatCn)){
					return s.subCatId;
				}
			}
			return 0;
		}
		public String getSubCatCn() {
			return subCatCn;
		}
		public void setSubCatCn(String subCatCn) {
			this.subCatCn = subCatCn;
		}
		public int getSubCatId() {
			return subCatId;
		}
		public void setSubCatId(int subCatId) {
			this.subCatId = subCatId;
		}
	}

	public enum SubCatEn{
		General("General",100),
		Food("Food",101),
		Drinks("Drinks",102),
		Croceries("Groceries",103),
		Shopping("Shopping",104),
		Personal("Personal",105),
		Entertain("Entertain",106),
		Movies("Movies",107),
		Social("Social",108),
		Transport("Transport",109),
		AppStore("AppStore",110),
		Mobile("Mobile",111),
		Computer("Computer",112),
		Gifts("Gifts",113),
		Housing("Housing",114),
		Travel("Travel",115),
		Tickets("Tickets",116),
		Books("Books",117),
		Medical("Medical",118),
		Transfer("Transfer",119),
		Insurance("Insurance",120),
		Utilities("Utilities",121),
		Rent("Rent",122),;
		private String subCatEn;
		private int subCatId;
		private SubCatEn(String subCatEn,int subCatId){
			this.subCatEn = subCatEn;
			this.subCatId = subCatId;
		}
		public static String getName(int subCatId){
			for(SubCatEn s : SubCatEn.values()){
				if(s.getSubCatId() == subCatId){
					return s.subCatEn;
				}
			}
			return null;
		}
		public static int getId(String subCatEn){
			for(SubCatEn s : SubCatEn.values()){
				if(s.getSubCatEn().equals(subCatEn)){
					return s.subCatId;
				}
			}
			return 0;
		}
		public String getSubCatEn() {
			return subCatEn;
		}
		public void setSubCatEn(String subCatEn) {
			this.subCatEn = subCatEn;
		}
		public int getSubCatId() {
			return subCatId;
		}
		public void setSubCatId(int subCatId) {
			this.subCatId = subCatId;
		}
	}

}
