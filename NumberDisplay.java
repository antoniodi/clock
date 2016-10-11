
/**
 * The NumberDisplay class represents a digital number display that can hold
 * values from zero to a given limit. The limit can be specified when creating
 * the display. The values range from zero (inclusive) to limit-1. If used,
 * for example, for the seconds on a digital clock, the limit would be 60, 
 * resulting in display values from 0 to 59. When incremented, the display 
 * automatically rolls over to zero when reaching the limit.
 * 
 * @author Michael Kolling and David J. Barnes
 * @version 2006.03.30
 */
public class NumberDisplay
{
    private int limit;
    private int value;
    private String dia;
    private String nombre;

   
     /**
     * Constructor for objects of class NumberDisplay.
     * Set the limit at which the display rolls over.
     */
    public NumberDisplay(int rollOverLimit, String nombre)
    {
        this.nombre=nombre;
        limit = rollOverLimit;
        value = 0;
    }
    /**
     * Return the current value.
     */
    public int getValue()
    {
        return value;
    }
    public String getDia(){
        return dia;
    }
    public void setDia(String dia){
         this.dia=dia;
    }
    /**
     * Return the display value (that is, the current value as a two-digit
     * String. If the value is less than ten, it will be padded with a leading
     * zero).
     */
    public String getDisplayValue()
    {
        if(value < 10) {
            return "0" + value;
        }
        else {
            return "" + value;
        }
    }

    /**
     * Set the value of the display to the new specified value. If the new
     * value is less than zero or over the limit, do nothing.
     */
    public void setValue(int replacementValue)
    {
        if((replacementValue >= 0) && (replacementValue < limit)) {
            if(nombre.equals("horas")){
                if(replacementValue<=12){
                    value = replacementValue;
                    dia="a.m";
                }else{
                    value = replacementValue-12;
                    dia="p.m";
                }
            }else{
            value = replacementValue;}
        }
    }

    /**
     * Increment the display value by one, rolling over to zero if the
     * limit is reached.
     */
    public void increment()
    {   
        if(limit == 24){
            value = (value + 1) % (limit/2);
            if(value==0){
                value=12;
                if(dia.equals("a.m")){
                    dia="p.m";
                   System.out.println(); 
                   System.out.println("hola1");
                }else{
                    dia="a.m";
                   System.out.println("hola"); 
                }
               
            }
            
            
            
        }else{
        value = (value + 1) % limit;}
    }
}
