package a2_2201040174;
public class PCReport {
    public static String displayReport(PC[] objs) {
        StringBuilder report = new StringBuilder();
        report.append("---------------------------------------------------------------------------------------------------");
        report.append("\n                                   PCROG REPORT\n");
        report.append("---------------------------------------------------------------------------------------------------");
        for (int i = 0; i < objs.length; i++) {
            report.append(String.format("\n%3d %20s %6d %15s %s\n", i + 1, objs[i].getModel(), objs[i].getYear(),
                    objs[i].getManufacturer(), formatComponents(objs[i].getComps())));
        }
        report.append("---------------------------------------------------------------------------------------------------");
        return report.toString();
    }

    private static String formatComponents(Set<String> comps) {
        StringBuilder format = new StringBuilder();
        int totalLength = 0;
        for (String comp : comps) {
            totalLength += comp.length();
            if (format.length() > 0) {
                format.append(", ");
            }
            format.append(comp);
        }
        if (format.length() > 0) {
            format.setLength(Math.min(47, totalLength + comps.size() - 1));
        }
        String compString = format.toString();
        if (totalLength >= 47) {
            compString = compString.substring(0, 46) + "...";
        }
        return "[" + compString + "]";
    }
}