package aufgabe4.braitenbergvehikel;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import aufgabe4.braitenbergvehikel.BraitenbergVehikel.Richtung;

/**
 * Simulation von Braitenberg-Vehikeln.
 * 
 * @author Philipp Jenke
 */
public class BVSimulation extends Observable implements Runnable{

  
  /**
   * 4.1 
   * boolean zum isGedrückt damit wir ob der thread laufen darf oder nicht.
   */
  public boolean isGedrueckt=false;
  /**
   * Position des Signals.
   */
  private Vektor2 signal = new Vektor2(150, 200);

  /**
   * Liste der zu simulierenden Vehikel
   */
  private List<BraitenbergVehikel> vehikel =
      new ArrayList<BraitenbergVehikel>();

  public BVSimulation() {
  }

  /**
   * Führt einen Simulationsschritt für alle Vehikel durch.
   */
  public void simulationsSchritt() {
    for (BraitenbergVehikel vehikel : this.vehikel) {
      // Berechne Sensorstärke
      vehikel.setSensorwert(Richtung.LINKS,
          getSignalstaerke(vehikel.getSensorPosition(Richtung.LINKS),
              vehikel.getOrientierung()));
      vehikel.setSensorwert(Richtung.RECHTS,
          getSignalstaerke(vehikel.getSensorPosition(Richtung.RECHTS),
              vehikel.getOrientierung()));

      // Bewege vehikel
      vehikel.bewege();
    }
  }

  /**
   * Berechnet die Signalstärke für einen Sensor durch die Lichtquelle.
   */
  private double getSignalstaerke(Vektor2 sensorPosition,
      Vektor2 orientierung) {
    Vektor2 d = signal.subtrahiere(sensorPosition);
    double entfernung = d.getNorm();
    d = d.skaliere(1.0 / entfernung);
    double cosWinkel = d.skalarProdukt(orientierung);
    if (cosWinkel < 0) {
      // Vehikel sieht vom Sensor weg.
      return 0;
    }

    // Winkel-basierte Signalstärke
    return cosWinkel;
  }

  public void vehikelHinzufuegen(BraitenbergVehikel vehikel) {
    this.vehikel.add(vehikel);
  }

  public int getAnzahlVehike() {
    return vehikel.size();
  }

  public BraitenbergVehikel getVehikel(int index) {
    return vehikel.get(index);
  }

  public Vektor2 getSignal() {
    return signal;
  }

  public void setSignal(double x, double y) {
    signal = new Vektor2(x, y);
    /**
     * informiert die Canvas über die veränderung des signals
     */
    notifyObservers();
    setChanged();
  }

  /**
 * 4.1 Thread und run implementiert
 */
  @Override
  public void run() {
    while(true){
    if(isGedrueckt){
      simulationsSchritt();
      
    }
    // wieso geht es nicht wenn sleep in der if bedingung ist.
      try {
        Thread.sleep(200);
      } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }
    
  }
  


    
    
      
      
    
      
     
    
  
}
