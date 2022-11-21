package runner;

public class TestUtils {

    public static String createPopUpIconTexts() {
        final String icon1 = "clear sky, ";
        final String icon2 = "few clouds, ";
        final String icon3 = "overcast clouds, ";
        final String icon4 = "drizzle, ";
        final String icon5 = "rain, ";
        final String icon6 = "shower rain, ";
        final String icon7 = "thunderstorm, ";
        final String icon8 = "snow, ";
        final String icon9 = "mist";

        return new StringBuilder()
                .append(icon1)
                .append(icon2)
                .append(icon3)
                .append(icon4)
                .append(icon5)
                .append(icon6)
                .append(icon7)
                .append(icon8)
                .append(icon9)
                .toString();
    }
}