package Helper;

import java.util.Random;

public class RandomHelp {
	public static String number() {
		//产生随机数对象
		Random random = new Random();
		//定义随机数的范围  将返回的int类型的数转换成String类型 ，
		String num = random.nextInt(9999)+"";
			
		//创建字符缓冲区
		StringBuffer buffer = new StringBuffer();
		//判断当num的长度小于四的时候进行拼接，凑成四位数的随机数
		//当随机数长度为1时，拼接三次，循环三次
		//当随机数长度为2时，拼接两次，循环三次
		//一次类推得到i<4-num.length();
		for(int i=0; i<4-num.length(); i++) {
			buffer.append("0");
		}
		//将拼接的0，拼接到最前面
		num = buffer.toString()+num;
		
		return num;
		
	}

	
	
}
