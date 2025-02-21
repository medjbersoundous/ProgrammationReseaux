public class Vecteur3d {
    private double x;
    private double y;
    private double z;
    public Vecteur3d(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    public void afficher() {
        System.out.println("< " + x + ", " + y + ", " + z + " >");
    }
    public double norme() {
        return Math.sqrt(x*x + y*y + z*z);
    }
    public static Vecteur3d somme(Vecteur3d v1, Vecteur3d v2) {
        return new Vecteur3d(
            v1.x + v2.x,
            v1.y + v2.y,
            v1.z + v2.z
        );
    }
    public double produitScalaire(Vecteur3d autre) {
        return this.x * autre.x + this.y * autre.y + this.z * autre.z;
    }
    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }
    public double getZ() {
        return z;
    }
    public static void main(String[] args) { 
        Vecteur3d v1 = new Vecteur3d(1.0, 2.0, 3.0);
        Vecteur3d v2 = new Vecteur3d(4.0, 5.0, 6.0);
        System.out.print("Vecteur v1: ");
        v1.afficher();
        System.out.print("Vecteur v2: ");
        v2.afficher();
        System.out.println("Norme de v1: " + v1.norme());
        System.out.println("Norme de v2: " + v2.norme());
        Vecteur3d somme = Vecteur3d.somme(v1, v2);
        System.out.print("Somme v1 + v2: ");
        somme.afficher();
        double produit = v1.produitScalaire(v2);
        System.out.println("Produit scalaire v1·v2: " + produit);
    }
}