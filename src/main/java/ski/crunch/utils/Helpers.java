package ski.crunch.utils;

import java.util.List;
import java.util.Map;

public class Helpers {

    public static void checkParameter(String parameter, Map<String, Object> input) throws MissingRequiredParameterException {
        if (!input.containsKey(parameter)) {
            throw new MissingRequiredParameterException("Parameter " + parameter + " not supplied");
        }
    }

    public static void checkRequiredParameters(Map<String, Object> input, List<String> requiredParameters) throws MissingRequiredParameterException {
        if (input == null) {
            throw new MissingRequiredParameterException("No ResourceProperties found");
        }
        for (String requiredParameter : requiredParameters) {
            checkParameter(requiredParameter, input);
        }
    }
}
