package augabe3_1;

public class Rangierbahnhof {

  /**
   * feste Anzahl an Gleisen für den Bahnhof
   */
  private Zug[] gleisArray = new Zug[3];

  public void einfahren() {
    for (int i = 0; i < gleisArray.length; i++) {
      if (gleisArray[i] == null) {
        gleisArray[i] = new Zug();
        return;
      }
    }
  }

  public void ausfahren() {
    for (int i = 0; i < gleisArray.length; i++) {
      if (gleisArray[i] != null) {
        gleisArray[i] = null;
        return;
      }
    }

  }

}
