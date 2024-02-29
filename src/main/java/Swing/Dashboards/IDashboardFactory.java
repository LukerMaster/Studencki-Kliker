package Swing.Dashboards;

import javax.swing.*;

/*
 * This is an implementation of Abstract Factory pattern, used in a different way
 * than described in GoF. All the factories are going to be used, instead of standard
 * switching between one of them based on some environmental variables.
 */
public interface IDashboardFactory {
    JComponent CreateDashboard();
}
