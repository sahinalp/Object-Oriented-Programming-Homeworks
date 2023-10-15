import java.util.Calendar;

public class HeartRatesCore {

    private HeartRates heartRates;
    public HeartRatesCore(HeartRates heartRates) {
        this.heartRates=heartRates;
    }

    public int calculateAge() {
        Calendar now = Calendar.getInstance();
        int currentYear = now.get(Calendar.YEAR);
        int age = currentYear - heartRates.getBirthYear();
        if (now.get(Calendar.MONTH) < heartRates.getBirthMonth() - 1 ||
                (now.get(Calendar.MONTH) == heartRates.getBirthMonth() && now.get(Calendar.DAY_OF_MONTH) < heartRates.getBirthDay())) {
            age--;
        }

        return age;
    }

    public int calculateMaximumHeartRate() {
        return 220 - calculateAge();
    }

    public String calculateTargetHeartRateRange() {
        int maxHeartRate = calculateMaximumHeartRate();
        int lowerRate = (int) (0.5 * maxHeartRate);
        int upperRate = (int) (0.85 * maxHeartRate);
        return lowerRate + " - " + upperRate;
    }
}
