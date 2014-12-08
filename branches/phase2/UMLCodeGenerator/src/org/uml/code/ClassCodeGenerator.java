package org.uml.code;

import java.util.List;
import org.uml.model.relations.CardinalityEnum;
import org.uml.model.components.ClassComponent;
import org.uml.model.components.ComponentBase;
import org.uml.model.relations.HasBaseRelation;
import org.uml.model.relations.ImplementsRelation;
import org.uml.model.components.InterfaceComponent;
import org.uml.model.relations.IsRelation;
import org.uml.model.components.PackageComponent;
import org.uml.model.relations.RelationBase;
import org.uml.model.relations.UseRelation;

/**
 * Class component's code generating class. Implements all necessary methods
 * that are used in order to generate code from ClassComponents
 *
 * @author zoran
 */
public class ClassCodeGenerator implements CodeGenerator {

    ClassComponent classComponent;
    List<RelationBase> relevantRelations;

    /**
     * Parameterless constructor. Does not instantiate any field.
     *
     */
    public ClassCodeGenerator() {
    }

    /**
     * Sets class component whose code needs to be generated.
     *
     * @param classComponent used for code generation
     */
    public void setClassComponent(ClassComponent classComponent) {
        this.classComponent = classComponent;
    }

    /**
     * Sets relevant relations - relations where previously set ClassComponent
     * is the source.
     *
     * @param relevantRelations List of relations with this object's
     * ClassComponent as a source
     */
    public void setRelevantRelations(List<RelationBase> relevantRelations) {
        this.relevantRelations = relevantRelations;
    }

    /**
     * Generates code for this object's ClassComponent. Along with standard
     * class definitions and descriptions, fields, methods and constructors are
     * also appended.
     *
     * @return code of the generated class
     * @see ClassComponent
     */
    @Override
    public String generateCode() {
        String code = "";
        PackageComponent pc = classComponent.getParentPackage();
        if (pc != null && !pc.getName().equals("")) {
            String pack = pc.getName();
            code += "package " + pack + "; \n";
        }
        String abstractModifierStr = "";
        if (classComponent.isAbstract()) {
            abstractModifierStr = "abstract";
        }
        String header = "public " + abstractModifierStr + " class " + classComponent.getName();
        String extendsClass = getClassThatIsExtended(relevantRelations);
        if (extendsClass != null) {
            header += " extends " + extendsClass;
        }
        String implementedClasses = getClassesThatAreImplemented(relevantRelations);
        if (!implementedClasses.equals("")) {
            header += " implements " + implementedClasses;
        }
        header += " { ";
        ConstructorCodeGenerator ccg = new ConstructorCodeGenerator(classComponent.getConstructors());
        String constructors = ccg.generateCode();
        FieldCodeGenerator fcg = new FieldCodeGenerator(classComponent.getFields());
        String fields = fcg.generateCode();
        fields += getFieldsFromUseRelations(relevantRelations);
        fields += getFieldsFromHasRelations(relevantRelations);
        MethodCodeGenerator mcg = new MethodCodeGenerator(classComponent.getMethods());
        String methods = mcg.generateCode();
        String methodsFromInterfaces = getMethodsFromInterfaces(relevantRelations);
        if (!methodsFromInterfaces.equals("")) {
            methods += methodsFromInterfaces;
        }
        String end = "\n }";
        //classComponent.get

        code += header + "\n";
        code += fields + "\n";
        code += constructors + "\n";
        code += methods + "\n";
        code += end;
        return code;
    }

    /**
     * Sets Class diagram component (casted to Class component), for this object
     * to generate code from.
     *
     * @param component used for code generating
     */
    @Override
    public void setComponent(ComponentBase component) {
        classComponent = (ClassComponent) component;
    }

    /**
     * Returns name of the class that is connected with this object's Class
     * component via Is relation - extends.
     *
     * @param relations where search should be conducted
     * @return(s) name of the extended class
     */
    public String getClassThatIsExtended(List<RelationBase> relations) {
        String extendedClassName = null;
        for (int i = 0; i < relations.size(); i++) {
            if (relations.get(i) instanceof IsRelation) {
                extendedClassName = ((ClassComponent) relations.get(i).getTarget()).getName();
            }
        }
        return extendedClassName;
    }

    /**
     * Returns name of the class that is connected with this object's Class
     * component via Implements relation.
     *
     * @param relations where search should be conducted
     * @return name(s) of the implemented class
     */
    public String getClassesThatAreImplemented(List<RelationBase> relations) {
        String implementedClasses = "";
        for (int i = 0; i < relations.size(); i++) {
            if (relations.get(i) instanceof ImplementsRelation) {
                implementedClasses += relations.get(i).getTarget().getName() + ", ";
            }
        }
        if (!implementedClasses.equals("")) {
            implementedClasses = implementedClasses.substring(0, implementedClasses.length() - 2);
        }
        return implementedClasses;
    }

    /**
     * Returns methods that are implemented from classComponent's interfaces.
     *
     * @param relations where search should be conducted
     * @return name(s) of the implemented methods
     */
    public String getMethodsFromInterfaces(List<RelationBase> relations) {
        String methods = "";
        for (int i = 0; i < relations.size(); i++) {
            if (relations.get(i) instanceof ImplementsRelation) {
                MethodCodeGenerator generator = new MethodCodeGenerator(((InterfaceComponent) relations.get(i).getTarget()).getMethods());
                methods += generator.generateCode();
            }
        }
        return methods;
    }

    /**
     * Returns all fields (with access modifiers, names and types) that are
     * implemented via Use relations.
     *
     * @param relations where search should be conducted
     * @return name(s) of the implemented fields
     */
    public String getFieldsFromUseRelations(List<RelationBase> relations) {
        String fields = "";
        for (int i = 0; i < relations.size(); i++) {
            if (relations.get(i) instanceof UseRelation) {
                String fieldType = relations.get(i).getTarget().getName();
                String fieldName = (fieldType.substring(0, 1)).toLowerCase() + fieldType.substring(1, fieldType.length());
                fields += "private " + fieldType + " " + fieldName + ";\n";
            }
        }
        return fields;
    }

    /**
     * Returns all fields (with access modifiers, names and types) that are
     * implemented via Has relations.
     *
     * @param relations where search should be conducted
     * @return name(s) of the implemented fields
     */
    public String getFieldsFromHasRelations(List<RelationBase> relations) {
        String fields = "";
        for (int i = 0; i < relations.size(); i++) {
            if (relations.get(i) instanceof HasBaseRelation) {
                HasBaseRelation hasRelation = (HasBaseRelation) relations.get(i);
                String fieldType = hasRelation.getTarget().getName();
                String fieldName = (fieldType.substring(0, 1)).toLowerCase() + fieldType.substring(1, fieldType.length());
                if (hasRelation.getCardinalityTarget().equals(CardinalityEnum.One2Many) || hasRelation.getCardinalityTarget().equals(CardinalityEnum.Zero2Many)) {
                    String field = "private " + hasRelation.getCollectionType() + "<" + hasRelation.getTarget().getName() + "> " + fieldName + "s;\n";
                    fields += field;
                } else {
                    String field = "private " + fieldType + " " + fieldName + ";\n";
                    fields += field;
                }
            }
        }
        return fields;
    }
}