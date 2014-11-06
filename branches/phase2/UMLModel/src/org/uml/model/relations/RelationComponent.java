package org.uml.model.relations;

import java.io.Serializable;
import java.util.Objects;
import org.uml.model.ClassDiagram;
import org.uml.model.ClassDiagramComponent;

/**
 * Relation between two UML Class Diagram components. 
 * Currently supports Has, Is, Uses and Implements relations using its subclasses.
 *
 * @author "NUGS"
 * @see HasRelationComponent
 * @see IsRelationComponent
 * @see UseRelationComponent
 * @see ImplementsRelationComponent
 * @see ClassDiagram
 * @see ClassDiagramComponent
 */
public abstract class RelationComponent implements Serializable {

    ClassDiagramComponent source;
    ClassDiagramComponent target;
    protected String name;

    /**
     * Default constructor without parameters used to create Relation object.
     */
    public RelationComponent() {
    }

    /**
     * Constructor with three parameters used to create Relation object and set
     * its name, source and target.
     *
     * @param source - from which ClassDiagramComponent does relation start
     * @param target - to which ClassDiagramComponent does relation go
     * @param name of the Relation
     * @see ClassDiagramComponent
     */
    public RelationComponent(ClassDiagramComponent source, ClassDiagramComponent target, String name) {
        this.source = source;
        this.target = target;
        this.name = name;
    }

    public ClassDiagramComponent getSource() {
        return source;
    }

    public ClassDiagramComponent getTarget() {
        return target;
    }

    public void setSource(ClassDiagramComponent source) {
        this.source = source;
    }

    public void setTarget(ClassDiagramComponent target) {
        this.target = target;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getXmlRepresentation() {
        return "Subclass should override this method";
    }
    
    public abstract boolean canConnect(ClassDiagramComponent source, ClassDiagramComponent target);
    
    @Override
    public abstract int hashCode();

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final RelationComponent other = (RelationComponent) obj;
        if (!Objects.equals(this.source, other.source)) {
            return false;
        }
        if (!Objects.equals(this.target, other.target)) {
            return false;
        }
        return true;
    }
    
}