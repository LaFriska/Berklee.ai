package jnotes.test;

import jnotes.core.notes.Notes;
import jnotes.test.testutil.Assertion;
import jnotes.test.testutil.Suite;

public class NotesTest {

    protected static void enharmonicSuite(){
        Main.test.addSuite(
                new Suite("Note Enharmonics").addAssertions(
                        new Assertion<>(true, Notes.A.equalsEnharmonically(Notes.B_DOUBLE_FLAT)),
                        new Assertion<>(true, Notes.C.equalsEnharmonically(Notes.D_DOUBLE_FLAT)),
                        new Assertion<>(true, Notes.F.equalsEnharmonically(Notes.G_DOUBLE_FLAT)),
                        new Assertion<>(false, Notes.B.equalsEnharmonically(Notes.C_DOUBLE_FLAT)),
                        new Assertion<>(false, Notes.E.equalsEnharmonically(Notes.A_DOUBLE_FLAT)),
                        new Assertion<>(true, Notes.F.equalsEnharmonically(Notes.E_SHARP)),
                        new Assertion<>(true, Notes.C.equalsEnharmonically(Notes.B_SHARP)),
                        new Assertion<>(true, Notes.E_FLAT.equalsEnharmonically(Notes.D_SHARP)),
                        new Assertion<>(true, Notes.A_FLAT.equalsEnharmonically(Notes.G_SHARP)),
                        new Assertion<>(false, Notes.C_FLAT.equalsEnharmonically(Notes.B_SHARP)),
                        new Assertion<>(false, Notes.B_FLAT.equalsEnharmonically(Notes.A_SHARP)),
                        new Assertion<>(false, Notes.F_FLAT.equalsEnharmonically(Notes.F_SHARP)),
                        new Assertion<>(true, Notes.D_SHARP.equalsEnharmonically(Notes.D_SHARP)),
                        new Assertion<>(true, Notes.F_SHARP.equalsEnharmonically(Notes.G_FLAT)),
                        new Assertion<>(true, Notes.D_SHARP.equalsEnharmonically(Notes.E_FLAT)),
                        new Assertion<>(false, Notes.E_SHARP.equalsEnharmonically(Notes.F_FLAT)),
                        new Assertion<>(true, Notes.D.equalsEnharmonically(Notes.D)),
                        new Assertion<>(true, Notes.A.equalsEnharmonically(Notes.A)),
                        new Assertion<>(false, Notes.B.equalsEnharmonically(Notes.D)),
                        new Assertion<>(true, Notes.C_FLAT.equalsEnharmonically(Notes.A_DOUBLE_SHARP)),
                        new Assertion<>(true, Notes.E_SHARP.equalsEnharmonically(Notes.G_DOUBLE_FLAT)),
                        new Assertion<>(true, Notes.F.equalsEnharmonically(Notes.E_SHARP))
                )
        );
    }

}
