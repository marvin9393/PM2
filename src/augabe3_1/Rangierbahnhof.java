package augabe3_1;


public class Rangierbahnhof {

  /**
   * feste Anzahl an Gleisen für den Bahnhof
   */
  private Zug[] gleisArray = new Zug[3];

  public synchronized int einfahren() {
    for (int i = 0; i < gleisArray.length; i++) {
      if (gleisArray[i] == null) {
        gleisArray[i] = new Zug();
        return i+1;
      }
    }
    return 0;
  }

  public synchronized int ausfahren() {
    for (int i = 0; i < gleisArray.length; i++) {
      if (gleisArray[i] != null) {
        gleisArray[i] = null;

        return i+1;
      }
    }
    return 0;
  }
  
  public static void main(String[] args) {
    Rangierbahnhof bhf=new Rangierbahnhof();
    Lokfuehrer fuehrer=new Lokfuehrer(bhf);
    fuehrer.start();
  }

}
