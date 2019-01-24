package eas.com.processor;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic;
import java.util.Set;

@SupportedAnnotationTypes("eas.com.annotations.Immutable")
@SupportedSourceVersion(SourceVersion.RELEASE_8)
public class SimpleAnnotationProcessor extends AbstractProcessor {


    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        //roundEnv.getElementsAnnotatedWith(Immutable.class).stream().forEach(o -> System.out.println(((Element) o).getSimpleName()));

        processingEnv.getMessager().printMessage(Diagnostic.Kind.ERROR, "Prepropessor Eduardo");

        return true;
    }
}
