package com.api.dto;

/**
 * Base class for DTO objects.
 */
public abstract class DtoObj {

    @Override
    public boolean equals(Object o) {
        return this == o || (o != null && getClass() == o.getClass());
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " {\n" +
                fieldsToString().toString() +
                "}";
    }

    protected StringBuilder fieldsToString() {
        return new StringBuilder();
    }

    /**
     * Append the given object (value) to string builder with each line indented by 4 spaces (except the first line).
     */
    protected void appendField(StringBuilder sb, String name, Object value) {
        sb.append("    ")
                .append(name)
                .append(": ")
                .append(value == null ? "null" : value.toString().replace("\n", "\n    "))
                .append("\n");
    }

}
