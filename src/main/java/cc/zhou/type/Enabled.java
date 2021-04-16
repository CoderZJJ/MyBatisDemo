package cc.zhou.type;

/**
* abner zjj
* 2021年4月8日 下午2:28:01
* 
* 
*/
public enum Enabled {
	disabled(0),
	enabled(1);
	
	private final int value;
	
	private Enabled(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
}
