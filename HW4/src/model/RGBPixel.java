package model;

/**
 * Class to represent the RGB values of any one pixel. Calculates the value, intensity, and luma of
 * the pixel upon construction, and provides methods for creating new pixels based on the RGB
 * values of this instance.
 */
class RGBPixel {
  private final int red;
  private final int green;
  private final int blue;
  private final int value;
  private final int intensity;
  private final int luma;

  /**
   * Constructor for an RGBPixel. Assigns r, g, and b to the given parameters, and calculates
   * the value, intensity, and luma according to the newly assigned rgb values.
   *
   * @param r int value for r
   * @param g int value for g
   * @param b int value for b
   */
  public RGBPixel(int r, int g, int b) {
    this.red = r;
    this.green = g;
    this.blue = b;
    this.value = Math.max(Math.max(r, g), b);
    this.intensity = (r + b + g) / 3;
    this.luma = (int) (0.2126 * r + 0.7152 * g + 0.0722 * b);
  }

  protected RGBPixel brighten(int amount) {
    return new RGBPixel(this.checkLimits(this.red + amount),
            this.checkLimits(this.green + amount),
            this.checkLimits(this.blue + amount));
  }

  private int checkLimits(int input) {
    if (input > 255) {
      return 255;
    } else if (input < 0) {
      return 0;
    }
    return input;
  }

  protected RGBPixel greyscale(Greyscale type) {
    switch (type) {
      case Red:
        return new RGBPixel(this.red, this.red, this.red);
      case Green:
        return new RGBPixel(this.green, this.green, this.green);
      case Blue:
        return new RGBPixel(this.blue, this.blue, this.blue);
    }
    return null;
  }

}
