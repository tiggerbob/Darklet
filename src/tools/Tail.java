package tools;

import java.io.*;

/**
 * Implements console-based log file tailing, or more specifically, tail following:
 * it is somewhat equivalent to the unix command "tail -f"
 */
public class Tail implements LogFileTailerListener
{
    /**
     * The log file tailer
     */
    private LogFileTailer tailer;
    public boolean threat = false;

    /**
     * Creates a new Tail instance to follow the specified file
     */
    public Tail( String filename )
    {
        tailer = new LogFileTailer( new File( filename ), 1000, false );
        tailer.addLogFileTailerListener( this );
        tailer.start();
    }

    /**
     * A new line has been added to the tailed log file
     *
     * @param line   The new line that has been added to the tailed log file
     */
    public void newLogFileLine(String line)
    {
        // TODO: create an actual algorithm for determining malware possibility
        if(!threat) {
            threat = true;
            System.out.println("Threat detected.");
            System.out.println("Log information is collected below.......");
        }
        System.out.println(line);
    }
}