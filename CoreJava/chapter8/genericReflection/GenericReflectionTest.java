package CoreJava.chapter8.genericReflection;

import java.lang.reflect.*;
import java.util.*;

/**
 * TODO
 *
 * @author nofirst
 * @date 2020-05-29 11:37
 */
public class GenericReflectionTest {
    public static void main(String[] args) {
        // read class name from command line args or user input
        String name;
        if (args.length > 0) name = args[0];
        else {
            try (Scanner in = new Scanner(System.in)) {
                System.out.println("Enter class name(e.g. java.util.Collections: ");
                name = in.next();
            }
        }

        try {
            Class<?> cl = Class.forName(name);
            printClass(cl);

            for (Method m : cl.getDeclaredMethods())
                printMethod(m);
        }catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
    }

    private static void printMethod(Method m) {
        String name = m.getName();
        System.out.println(Modifier.toString(m.getModifiers()));
        System.out.println(" ");
        printTypes(m.getTypeParameters(), "<", ", ", ">", true);

        printType(m.getGenericReturnType(), false);
        System.out.println(" ");
        System.out.println(name);
        System.out.println("(");
        printTypes(m.getGenericParameterTypes(), "<", ", ", ">", false);
        System.out.println(")");
    }

    private static void printClass(Class<?> cl) {
        System.out.println(cl);

        printTypes(cl.getTypeParameters(), "<", ", ", ">", true);

        Type sc = cl.getGenericSuperclass();
        if(sc != null)
        {
            System.out.println(" extends ");
            printType(sc, false);
        }
    }

    private static void printTypes(Type[] types, String pre, String sep, String suf, boolean isDefinition) {
        if (pre.equals("extends ") && Arrays.equals(types, new Type[] { Object.class })) return;
        if (types.length > 0) System.out.print(pre);
        for (int i = 0; i< types.length; i ++)
        {
            if(i>0) System.out.print(sep);
            printType(types[i], isDefinition);
        }

        if (types.length > 0) System.out.print(suf);
    }

    private static void printType(Type type, boolean isDefinition) {
        if (type instanceof Class)
        {
            Class<?> t = (Class<?>) type;
            System.out.print (t.getName() ) ;
        }
        else if (type instanceof TypeVariable)
        {
            TypeVariable<?> t = (TypeVariable<?>) type;
            System.out.print(t .getName());
            if (isDefinition)
                printTypes(t.getBounds(), " extends ", " & ", "", false);
        }
        else if (type instanceof WildcardType)
        {
            WildcardType t = (WildcardType) type; System.out .print ( "?") ;
            printTypes(t.getUpperBounds(), " extends "," & ", "", false);
            printTypes(t.getLowerBounds(), " super "," & ", "", false);
        }
        else if (type instanceof ParameterizedType) {
            ParameterizedType t = (ParameterizedType) type;
            Type owner = t.getOwnerType();
            if (owner != null) {
                printType(owner, false);
                System.out.print(".");
            }
            printType(t.getRawType(), false);
            printTypes(t.getActualTypeArguments(), "<", ", ", ">", false);
        }
        else if(type instanceof GenericArrayType)
        {
            GenericArrayType t = (GenericArrayType) type;
            System.out .print("");
            printType(t.getGenericComponentType(), isDefinition);
            System.out.print("[]");
        }
    }
}