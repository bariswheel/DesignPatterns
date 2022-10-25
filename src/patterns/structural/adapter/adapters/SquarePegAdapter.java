package patterns.structural.adapter.adapters;

import patterns.structural.adapter.round.RoundPeg;
import patterns.structural.adapter.square.SquarePeg;

/**
 * Adapter allows fitting square pegs into round holes.
 */
public class SquarePegAdapter extends RoundPeg {
    private SquarePeg peg; // our adapter will have a reference to the incompatible entity, the square peg
    // this is the hollow diamond (contains a reference to)

    public SquarePegAdapter(SquarePeg peg) {    // whenever method name is the same as class name, it's a constructor.  
        this.peg = peg;
    }

    @Override
    public double getRadius() {
        double result;
        // Calculate a minimum circle radius, which can fit this peg.
        result = (Math.sqrt(Math.pow((peg.getWidth() / 2), 2) * 2));
        return result;
    }
}
