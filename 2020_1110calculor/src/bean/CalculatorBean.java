package bean;

public class CalculatorBean {
	private double firstNum=0;
	private double secondNum=0;
	private String operator="+";
	private double sum=0;
	 public CalculatorBean() {
	    }
	    public CalculatorBean(double firstNum, double secondNum, String operator,double sum) {
	        this.firstNum = firstNum;
	        this.secondNum = secondNum;
	        this.operator = operator;
	        this.sum=sum;
	    }
	public double getFirstNum() {
		return firstNum;
	}
	public void setFirstNum(double firstNum) {
		this.firstNum = firstNum;
	}
	public double getSecondNum() {
		return secondNum;
	}
	public void setSecondNum(double secondNum) {
		this.secondNum = secondNum;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public double getSum() {
		return sum;
	}
	public void setSum(double sum) {
		this.sum = sum;
	}
	 public void calcuate(){

	       switch (operator) {
	           case "+":
	               sum = firstNum + secondNum;
	               break;
	           case "-":
	               sum = firstNum - secondNum;
	               break;
	           case "x":
	               sum = firstNum * secondNum;
	               break;
	           case "/": {
	               if(secondNum==0){
	                   throw new RuntimeException("被除数不能为0");
	               }
	               sum = firstNum / secondNum;
	               break;
	           }
	           default:
	               sum = 0;
	       }
	    }
}
