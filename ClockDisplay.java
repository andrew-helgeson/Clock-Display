
/**
 * The ClockDisplay class implements a digital clock display for a
 * 12 hour clock. The clock shows hours and minutes. Includes an AM and PM
 * indicator
 * The clock display receives "ticks" (via the timeTick method) every minute
 * and reacts by incrementing the display. This is done in the usual clock
 * fashion: the hour increments when the minutes roll over to zero.
 * 
 * @author Andrew Helgeson
 * @version 2018.10.01
 */
public class ClockDisplay
{
    private NumberDisplay hours;
    private NumberDisplay minutes;
    private String twelveHourDisplayString;
    private String updatedHours;
    private String meridianIndicator;
    private String displayString; // simulates the actual display
    
    /**
     * Constructor for ClockDisplay objects. This constructor 
     * creates a new clock set at 12:00 AM.
     */
    public ClockDisplay()
    {
        hours = new NumberDisplay(24);
        minutes = new NumberDisplay(60);
        meridianIndicator = "AM";
        updateDisplay();
        update12HourDisplay();
    }

    /**
     * Constructor for ClockDisplay objects. This constructor
     * creates a new clock set at the time specified by the 
     * parameters.
     */
    public ClockDisplay(int hour, int minute)
    {
        hours = new NumberDisplay(24);
        minutes = new NumberDisplay(60);
        setTime(hour, minute);
    }

    /**
     * This method should get called once every minute - it makes
     * the clock display go one minute forward.
     */
    public void timeTick()
    {
        minutes.increment();
        if(minutes.getValue() == 0) {  // it just rolled over!
            hours.increment();
        }
        updateDisplay();
        update12HourDisplay();
    }

    /**
     * Set the time of the display to the specified hour and
     * minute.
     */
    public void setTime(int hour, int minute)
    {
        hours.setValue(hour);
        minutes.setValue(minute);
        updateDisplay();
        update12HourDisplay();
    }

    
    public String get12HourInternalDisplay()
    {
        return twelveHourDisplayString;
    }
    
    public String getTime()
    {
        return displayString;
    }
    
    private void update12HourDisplay()
    {
        if (hours.getValue() == 0){
            updatedHours = "12";
        }
        else if (hours.getValue() == 13){
            updatedHours = "01";
        }
        else if (hours.getValue() == 14){
            updatedHours = "02";
        }
        else if (hours.getValue() == 15){
            updatedHours = "03";
        }
        else if (hours.getValue() == 16){
            updatedHours = "04";
        }
        else if (hours.getValue() == 17){
            updatedHours = "05";
        }
        else if (hours.getValue() == 18){
            updatedHours = "06";
        }
        else if (hours.getValue() == 19){
            updatedHours = "07";
        }
        else if (hours.getValue() == 20){
            updatedHours = "08";
        }
        else if (hours.getValue() == 21){
            updatedHours = "09";
        }
        else if (hours.getValue() == 22){
            updatedHours = "10";
        }
        else if (hours.getValue() == 23){
            updatedHours = "11";
        }
        else {
            updatedHours = hours.getDisplayValue();
        }
        if (hours.getValue() < 12){
            meridianIndicator = "AM";
        }
        else {
            meridianIndicator = "PM";
        }
        
        twelveHourDisplayString = updatedHours + ":" + minutes.getDisplayValue()
        + " " + meridianIndicator;
    }
    
    /**
     * Update the internal string that represents the display.
     */
    private void updateDisplay()
    {
        displayString = hours.getDisplayValue() + ":" + 
                        minutes.getDisplayValue();
    }
}
