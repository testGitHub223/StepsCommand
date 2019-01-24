package t000002NewCommand.a.core.coreServerConfig.converters;

import org.aeonbits.owner.Converter;
import org.openqa.selenium.Dimension;

import java.lang.reflect.Method;

public class DimensionConverter implements Converter<Dimension> {
    public Dimension convert(Method targetMethod, String text) {

        int index1 = text.indexOf(", ");
        int index2 = text.length();

        String str1 = text.substring(0, index1);
        String str2 = text.substring(index1 + 2, index2);

        int intX = Integer.valueOf(str1);
        int intY = Integer.valueOf(str2);

        return new Dimension(intX, intY);
    }
}
