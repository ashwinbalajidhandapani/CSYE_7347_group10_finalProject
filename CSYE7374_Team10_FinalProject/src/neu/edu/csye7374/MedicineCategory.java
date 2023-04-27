package neu.edu.csye7374;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum MedicineCategory {
	Tablet,
	Drops,
	Injection,
	Capsules,
	Liquid;

	public static List<String> getMedicineCategoryList() {
		return Stream.of(MedicineCategory.values()).map(MedicineCategory::name).collect(Collectors.toList());
	}

	public static String[] getBookCategoryArray() {

		return Arrays.stream(MedicineCategory.values()).map(MedicineCategory::name).toArray(String[]::new);
	}

	public static MedicineCategory getMedicineCategory(String s) {
		MedicineCategory result = null;
		switch (s.toLowerCase()) {
			case "tablet":
				result = MedicineCategory.Tablet;
				break;
			case "drops":
				result = MedicineCategory.Drops;
				break;
			case "injection":
				result = MedicineCategory.Injection;
				break;
			case "capsules":
				result = MedicineCategory.Capsules;
				break;
			case "liquid":
				result = MedicineCategory.Liquid;
				break;
		}
		return result;
	}
}
