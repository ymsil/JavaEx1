/**
 * Created by ymsil on 11/7/2016.
 */
public abstract class CommunityMember implements DebtsAndRights
{
    private int Id;
    private Gender gender;
    private String name;
    private String address;
    private String dateOfBirth;
    private int weeklyTorahHours;
    private int weeklyWorkHours;
    private int monthlyIncome;
    private VolunteeringActivity volunteeringActivity;

    public CommunityMember(int id, Gender gender, String name, String address, String dateOfBirth,
                           int weeklyTorahHours, int weeklyWorkHours, int monthlyIncome,
                           VolunteeringActivity volunteeringActivity)
            throws Exception
    {
        Id = id;
        this.gender = gender;
        this.name = name;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        this.weeklyTorahHours = weeklyTorahHours;
        this.weeklyWorkHours = weeklyWorkHours;
        this.monthlyIncome = monthlyIncome;
        // 2/3 of hours in week: (24*7)*(2/3) = 112
        if (weeklyTorahHours + weeklyWorkHours < 112)
            throw new Exception("Not enough working or learning Torah hours in a week.\n" +
                    "Sorry! can't be a member.");
        if ( volunteeringActivity != null ) this.volunteeringActivity = volunteeringActivity;
    }

    public boolean isToratoOmanoto()
    {
        return weeklyWorkHours == 0;
    }

    public int getId() {
        return Id;
    }
    public void setId(int id) {
        Id = id;
    }
    public Gender getGender() {
        return gender;
    }
    public void setGender(Gender gender) {
        this.gender = gender;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getDateOfBirth() {
        return dateOfBirth;
    }
    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    public int getWeeklyTorahHours() {
        return weeklyTorahHours;
    }
    public void setWeeklyTorahHours(int weeklyTorahHours) {
        this.weeklyTorahHours = weeklyTorahHours;
    }
    public int getWeeklyWorkHours() {
        return weeklyWorkHours;
    }
    public void setWeeklyWorkHours(int weeklyWorkHours) {
        this.weeklyWorkHours = weeklyWorkHours;
    }
    public int getMonthlyIncome() {
        return monthlyIncome;
    }
    public void setMonthlyIncome(int monthlyIncome) {
        this.monthlyIncome = monthlyIncome;
    }
    public VolunteeringActivity getVolunteeringActivity() {
        return volunteeringActivity;
    }
    public void setVolunteeringActivity(VolunteeringActivity volunteeringActivity) {
        this.volunteeringActivity = volunteeringActivity;
    }

    @Override
    public String toString() {
        return (Id + " " + name + " " + gender.toString() + " " + address + " " + dateOfBirth + "\n" +
                "weekly Torah Hours: " + weeklyTorahHours + "\n" +
                "weekly work Hours: " + weeklyWorkHours + "\n" +
                "income: " + monthlyIncome + "\n" +
                "volunteering activity: " + volunteeringActivity.toString());
    }
}
