package Helper;

import java.util.Random;

public class RandomHelp {
	public static String number() {
		//�������������
		Random random = new Random();
		//����������ķ�Χ  �����ص�int���͵���ת����String���� ��
		String num = random.nextInt(9999)+"";
			
		//�����ַ�������
		StringBuffer buffer = new StringBuffer();
		//�жϵ�num�ĳ���С���ĵ�ʱ�����ƴ�ӣ��ճ���λ���������
		//�����������Ϊ1ʱ��ƴ�����Σ�ѭ������
		//�����������Ϊ2ʱ��ƴ�����Σ�ѭ������
		//һ�����Ƶõ�i<4-num.length();
		for(int i=0; i<4-num.length(); i++) {
			buffer.append("0");
		}
		//��ƴ�ӵ�0��ƴ�ӵ���ǰ��
		num = buffer.toString()+num;
		
		return num;
		
	}

	
	
}
