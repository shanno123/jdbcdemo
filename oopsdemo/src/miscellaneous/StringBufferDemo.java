package miscellaneous;

//mutable
public class StringBufferDemo {

	public static void main(String[] args) {
		StringBuffer buf = new StringBuffer("Java");//mutable string
		
        buf.append(" Guide Ver1/"); // append--to add // Java Guide Ver1/7
        buf.append(7);
        int index = 5;   // Insert  // Java Student Guide Ver1/7
        buf.insert(index, "Student "); // set in the middle                        
        index = 23;      // Set  // Java Student Guide Ver1.7
        buf.setCharAt(index, '.');                                   
        int start = 24;   // Replace  // Java Student Guide Ver1.8
        int end = 25;
        buf.replace(start, end, "8"); //start-->to end                              
        String s = buf.toString();   //Convert to string
        System.out.println(s);
        System.out.println(buf.reverse());
        
	}

}
