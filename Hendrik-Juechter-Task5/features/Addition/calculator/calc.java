package calculator;

public class calc {

	private String output;
	
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
		setOutput(input + " = " + ergebnis);
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
	
	private double add(Double[] values) {
		return values[0] + values[1];
	}

	/**
	 * getter
	 * @return the output
	 */
	public String getOutput() {
		return output;
	}

	/**
	 * setter
	 * @param output the output to set
	 */
	public void setOutput(String output) {
		this.output = output;
	}
}
