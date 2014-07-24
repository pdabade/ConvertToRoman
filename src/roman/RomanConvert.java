package roman;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RomanConvert {
	
	private static final String[] RCODE = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
	private static final int[] BVAL = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
	
	public static String binaryToRoman(int binary)
	{
		if(binary<=0 || binary>=4000)
			throw new NumberFormatException("Value outside roman range");
		
		String roman="";
		
		for(int i=0;i<RCODE.length;i++)
		{
			while(binary >= BVAL[i])
			{
				binary = binary - BVAL[i];
				roman += RCODE[i];
			}			
		}		
		return roman;		
	}
	
	public static int romanToDecimal(String roman)
	{
		int dec = 0;
		
		roman = roman.toUpperCase();
		for(int i=0;i<roman.length();i++)
		{
			char c = roman.charAt(i);
			
			switch(c)
			{
			case 'M':
				dec += 1000;
				break;
				
			case 'D':
				dec += 500;
				break;
				
			case 'L':
				dec += 50;
				break;
				
			case 'V':
				dec += 5;
				break;
				
			case 'C':
				if(roman.charAt(i+1)=='M')
				{
					dec += 900;
					i++;
				}
				else if(roman.charAt(i+1)=='D')
				{
					dec += 400;
					i++;
				}
				else
					dec += 100;
				break;
			case 'X':
				if(roman.charAt(i+1)=='L')
				{
					dec += 40;
					i++;
				}
				else if(roman.charAt(i+1)=='C')
				{
					dec += 90;
					i++;
				}
				else
					dec += 10;
				break;
			case 'I':
				if(roman.charAt(i+1)=='V')
				{
					dec += 4;
					i++;
				}
				else if(roman.charAt(i+1)=='X')
				{
					dec += 9;
					i++;
				}
				else
					dec += 1;
				break;
			}
		}
		
		return dec;
	}
	
	public static void main(String args[])
	{
		int binary;
		String input;
		System.out.print("Enter decimal value:");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			input = br.readLine();
			binary = Integer.parseInt(input);
			String roman = binaryToRoman(binary);
			System.out.println("Roman equivalent : "+roman);
			
			System.out.print("Enter roman value:");
			input = br.readLine();
			binary = romanToDecimal(input);
			System.out.println("Decimal equivalent : "+binary);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

