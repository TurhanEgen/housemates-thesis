package com.turhan.housemates.utility;

import javax.swing.*;
import java.util.List;

public final class Util
{
    public static<E> String arrangeList(List<E> list)
    {
        return list.toString().replace("[", "").replace("]", "").replace(",", "");
    }

    public static void showGeneralExceptionInfo(Exception e)
    {
        System.err.println( createGeneralExceptionInfo(e) );
    }

    public static String createGeneralExceptionInfo(Exception e)
    {
        return e.getClass().getSimpleName() + " has been occured. Exception message: " + e.getMessage();
    }

    public static <E> void showListElements(List<E> list)
    {
        System.out.println("\nList elements:");

        for (E entity : list)
        {
            System.out.println(entity);
        }
    }

    public static <E> void showArrayElements(E[] array)
    {
        System.out.println("\nArray elements:");

        for (int i = 0; i < array.length; i++)
        {
            System.out.println(array[i]);
        }
    }

    public static void showQuestionMessage(Object message)
    {
        JOptionPane.showMessageDialog(null, message, "Question Message", JOptionPane.QUESTION_MESSAGE);
    }

    public static void showErrorMessage(Object message)
    {
        JOptionPane.showMessageDialog(null, message, "Error Message", JOptionPane.ERROR_MESSAGE);
    }

    public static void showWarningMessage(Object message)
    {
        JOptionPane.showMessageDialog(null, message, "Warning Message", JOptionPane.WARNING_MESSAGE);
    }

    public static void showInfoMessage(Object message)
    {
        JOptionPane.showMessageDialog(null, message, "Info Message", JOptionPane.INFORMATION_MESSAGE);
    }
}