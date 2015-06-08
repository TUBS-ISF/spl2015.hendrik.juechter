package calculator;

public class calc {

	
	
	public calc() {
		
	}
	
	public String calculate(String input) {
		double ergebnis = 0;
		System.out.println(input);
		if(input.contains("+")){
			ergebnis = add(parse("\\+", input));
		} else if(input.contains("-")){
			ergebnis = sub(parse("-", input));
		} else if(input.contains("*")){
			ergebnis = mult(parse("\\*", input));
		} else if(input.contains("/")){
			ergebnis = div(parse("/", input));
		}
		return "" + ergebnis;
	}
	
	private Double[] parse (String sign, String input) {
		String[] values = input.split(sign);
		Double[] newValues = new Double[2];
		newValues[0] = Double.parseDouble(values[0]);
		System.out.println(newValues[0]);
		newValues[1] = Double.parseDouble(values[1]);
		System.out.println(newValues[1]);
		return newValues;
	}
	
	private double mult(Double[] values) {
		return values[0] * values[1];
	}
	
	private double div(Double[] values) {
		return values[0] / values[1];
	}
	
	private double sub(Double[] values) {
		return values[0] - values[1];
	}
	
	private double add(Double[] values) {
		return values[0] + values[1];
	}
}
