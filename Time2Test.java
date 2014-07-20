// Fig. 8.5: Time2.java
// Time2 class declaration with overloaded constructors.  
class Time2
{
   //private int hour;   // 0 - 23
   //private int minute; // 0 - 59
   private static int second; // 0 - 59

   // Time2 no-argument constructor: initializes each instance variable 
   // to zero; ensures that Time2 objects start in a consistent state
   public Time2()
   {
      this( 0 ); // invoke Time2 constructor with three arguments
   } // end Time2 no-argument constructor

   // Time2 constructor: hour supplied, minute and second defaulted to 0
   public Time2( int h ) 
   { 
      this.second = ( h*3600 ); // invoke Time2 constructor with three arguments
   } // end Time2 one-argument constructor

   // Time2 constructor: hour and minute supplied, second defaulted to 0
   public Time2( int h, int m ) 
   { 
      this( h*3600 + m*60 ); // invoke Time2 constructor with three arguments
   } // end Time2 two-argument constructor 

   // Time2 constructor: hour, minute and second supplied
   public Time2( int h, int m, int s ) 
   { 
      setTime( h,m,s); // invoke setTime to validate time
   } // end Time2 three-argument constructor 

   // Time2 constructor: another Time2 object supplied
   public Time2( Time2 time )
   {
      // invoke Time2 three-argument constructor
	  int h = getHour();
	  int m = getMinute();
      this.second = ( h*3600 + m*60 + time.getSecond());
   } // end Time2 constructor with a Time2 object argument

   // Set Methods
   // set a new time value using universal time; ensure that 
   // the data remains consistent by setting invalid values to zero
   public void setTime( int h, int m,int s )
   {
      setHour( h );   // set the hour
	//  second+=second;
	//  System.out.println("second tra ve by gio " + second);
	  setMinute( m ); // set the minute
	 // second+=second;
	 // System.out.println("second tra ve gio va phut " + second);
      setSecond( s ); // set the second
	 // second+=second;
	 // System.out.println("second tra ve " + second);
   } // end method setTime

   // validate and set hour 
   public void setHour( int h ) 
   {
		int hr = ( ( h >= 0 && h < 24 ) ? h : h%24 );
		//System.out.println(hr);
		second = hr*3600;
		System.out.println( "Second return by hour " +second);
   } // end method setHour

   // validate and set minute 
   public void setMinute( int m ) 
   { 
      int mi = ( ( m >= 0 && m < 60 ) ? m : 0 );
	  second += mi*60;
	  System.out.println("Second return by hour add to minute " +second);
   } // end method setMinute

   // validate and set second 
   public void setSecond( int s ) 
   { 
      int se =( ( s >= 0 && s < 60 ) ? s : 0 ); 
	  second+=se;
	  System.out.println("Total second " + second);
   } // end method setSecond

   // Get Methods
   // get hour value
   public int getHour() 
   { 
      int h = second/3600; 
	  h = ((h>=0 && h<24) ? h :0 );
	  //System.out.println("gio tra ve" + h);
	  return h;
   } // end method getHour

   // get minute value
   public int getMinute() 
   { 
      int m= (second%3600)/60;
	  m = ((m>=0 && m<60) ? m :0);
	  System.out.println("phut tra ve: " + m);
	  return m;
   } // end method getMinute

   // get second value
   public int getSecond() 
   {
		second = second % 60;
      return second; 
   } // end method getSecond

   // convert to String in universal-time format (HH:MM:SS)
   public String toUniversalString()
   {
      return String.format( 
         "%02d:%02d:%02d", getHour(), getMinute(), getSecond() );
   } // end method toUniversalString

   // convert to String in standard-time format (H:MM:SS AM or PM)
   public String toString()
   {
      return String.format( "%d:%02d:%02d  %s", 
         ( (getHour() == 0 || getHour() == 12) ? 12 : getHour() % 12 ),
         getMinute(), getSecond(), ( getHour() < 12 ? "AM" : "PM" ) );
   } // end method toString
} // end class Time2
public class Time2Test
{
	public static void main (String [] args)
	{
		System.out.println("Time initialize for test : 25h:20m:30s ");
		Time2 time = new Time2(25,20,30);
		System.out.print("The time " + time.toString());
		//String st = ((time.getHour() <12 ? "AM" : "PM"));
		//System.out.print(st);
	}
}