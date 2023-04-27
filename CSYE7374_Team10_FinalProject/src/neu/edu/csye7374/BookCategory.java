package neu.edu.csye7374;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum BookCategory {
	Magazine,
	Fiction,
	Documentary,
	Academic,
	Thriller,
	Scifi;
	
    public static List<String> getBookCategoryList(){
        
        return Stream.of(BookCategory.values()).map(BookCategory::name).collect(Collectors.toList());
    }
    
    public static String[] getBookCategoryArray() {
        
        return Arrays.stream(BookCategory.values()).map(BookCategory::name).toArray(String[]::new);
    }
    
    public static BookCategory getBookCategory(String s) {
    	BookCategory result = null;
    	switch(s.toLowerCase()) {
    	case "fiction":
    		result = BookCategory.Fiction;
    		break;
	    case "documentary":
	    	result = BookCategory.Documentary;
	    	break;
		case "academic":
			result = BookCategory.Academic;
			break;
		case "thriller":
			result = BookCategory.Thriller;
			break;
		case "scifi":
			result = BookCategory.Scifi;
			break;
		default:
			result = BookCategory.Magazine;
			break;
		}
    	return result;
    }
}
