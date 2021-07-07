
/**
 * Write a description of class Tester here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;

public class Tester
{
    public void testLogEntry() {
        LogEntry le = new LogEntry("1.2.3.4", new Date(), "example request", 200, 500);
        System.out.println(le);
        LogEntry le2 = new LogEntry("1.2.100.4", new Date(), "example request 2", 300, 400);
        System.out.println(le2);
    }
    
    public void testLogAnalyzer() {
        // complete method
        LogAnalyzer log = new LogAnalyzer ();
        log.readFile();
        log.printAll();
    }
    
    public void testUniqueIp (){
        LogAnalyzer records = new LogAnalyzer ();
        records.readFile();
        System.out.println(records.countUniquelPs());
    }
    
    public void testPrintAllHigherThanNum (){
        LogAnalyzer records = new LogAnalyzer ();
        records.readFile();
        records.printAllHigherThanNum(400);
    }
    
    public void testUniqueIPVisitsOnDay (){
        LogAnalyzer records = new LogAnalyzer ();
        records.readFile();
        System.out.println(records.uniqueIPVisitsOnDay("Sep 24").size());
    }
    
    public void testCountUniqueIPsInRange(){
        LogAnalyzer records = new LogAnalyzer ();
        records.readFile();
        System.out.println(records.countUniqueIPsInRange(200,299));
    } 
    
    public void testCountVisitsPerIP (){
        LogAnalyzer records = new LogAnalyzer ();
        records.readFile(); 
        System.out.println(records.countVisitsPerIP());
    }
    
    public void testMostNumberVisitsByIP (){
        LogAnalyzer records = new LogAnalyzer ();
        records.readFile();
        System.out.println(records.mostNumberVisitsByIP(records.countVisitsPerIP()));
    }
    
    public void testIPsMostVisits (){
        LogAnalyzer records = new LogAnalyzer ();
        records.readFile();
        System.out.println(records.iPsMostVisits(records.countVisitsPerIP()));      
    }
    
    public void testIPsForDays (){
        LogAnalyzer records = new LogAnalyzer ();
        records.readFile();
        System.out.println(records.iPsForDays());
    }
    
    public void testDayWithMostIPVisits (){
        LogAnalyzer records = new LogAnalyzer ();
        records.readFile();
        System.out.println(records.dayWithMostIPVisits(records.iPsForDays()));
    }
    
    public void testIPsWithMostVisitsOnDay (){
        LogAnalyzer records = new LogAnalyzer ();
        records.readFile();        
        System.out.println(records.iPsWithMostVisitsOnDay(records.iPsForDays(),"Sep 30"));    
    }
}




















