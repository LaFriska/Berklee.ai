package jnotes.test;

import jnotes.core.notes.Alteration;
import jnotes.core.notes.Note;
import jnotes.core.notes.NoteBase;
import jnotes.core.notes.Notes;
import jnotes.test.testutil.Assertion;
import jnotes.test.testutil.Suite;

public class NotesTest {

    protected static void comparison(){
        Main.test.addSuite(
                new Suite("Notes.Comparison.Enharmonics").addAssertions(
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

                        new Assertion<>(true, Notes.B_FLAT.equalsEnharmonically(Notes.A_SHARP)),
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
                        new Assertion<>(true, Notes.F.equalsEnharmonically(Notes.E_SHARP)),
                        new Assertion<>(true, Notes.B_DOUBLE_SHARP.equalsEnharmonically(Notes.C_SHARP)),
                        new Assertion<>(true, Notes.C_DOUBLE_FLAT.equalsEnharmonically(Notes.A_SHARP)),
                        new Assertion<>(true, Notes.C_FLAT.equalsEnharmonically(Notes.B))
                )
        );

        Main.test.addSuite(
                new Suite("Notes.Comparison.Equivalency").addAssertions(
                        new Assertion<>(true, Notes.A.equals(new Note(NoteBase.A))),
                        new Assertion<>(true, Notes.B_DOUBLE_SHARP.equals(new Note(NoteBase.B, Alteration.DOUBLE_SHARP))),
                        new Assertion<>(false, Notes.B_SHARP.equals(new Note(NoteBase.B, Alteration.DOUBLE_SHARP))),
                        new Assertion<>(true, Notes.C.equals(new Note(NoteBase.C))),
                        new Assertion<>(true, Notes.C_SHARP.equals(new Note(NoteBase.C, Alteration.SHARP))),
                        new Assertion<>(false, Notes.E.equals(new Note(NoteBase.D, Alteration.DOUBLE_SHARP))),
                        new Assertion<>(false, Notes.G_FLAT.equals(new Note(NoteBase.A, Alteration.SHARP))),
                        new Assertion<>(false, Notes.F_FLAT.equals(new Note(NoteBase.D, Alteration.DOUBLE_SHARP))),
                        new Assertion<>(true, Notes.C_DOUBLE_FLAT.equals(new Note(NoteBase.C, Alteration.DOUBLE_FLAT)))
                )
        );

        Main.test.addSuite(
                new Suite("Notes.Comparison.NoteValue").addAssertions(
                        new Assertion<>(1, Notes.C.getValue()),
                        new Assertion<>(4, Notes.E_FLAT.getValue()),
                        new Assertion<>(4, Notes.D_SHARP.getValue()),
                        new Assertion<>(7, Notes.G_FLAT.getValue()),
                        new Assertion<>(6, Notes.F.getValue()),
                        new Assertion<>(10, Notes.G_DOUBLE_SHARP.getValue()),
                        new Assertion<>(12, Notes.B.getValue()),
                        new Assertion<>(12, Notes.A_DOUBLE_SHARP.getValue())
                )
        );
    }

    protected static void pitch(){
        Main.test.addSuite(
                new Suite("Notes.Pitch.OctaveValue").addAssertions(
                        new Assertion<>(440, Math.round(Notes.A.createMutableClone().setOctave(4).getHertz())),
                        new Assertion<>(33, Math.round(Notes.C.createMutableClone().setOctave(1).getHertz())),
                        new Assertion<>(58, Math.round(Notes.A_SHARP.createMutableClone().setOctave(1).getHertz())),
                        new Assertion<>(3951, Math.round(Notes.B.createMutableClone().setOctave(7).getHertz())),
                        new Assertion<>(3520, Math.round(Notes.G_DOUBLE_SHARP.createMutableClone().setOctave(7).getHertz())),
                        new Assertion<>(4186, Math.round(Notes.C.createMutableClone().setOctave(8).getHertz())),
                        new Assertion<>(1760, Math.round(Notes.A.createMutableClone().setOctave(6).getHertz())),
                        new Assertion<>(1245, Math.round(Notes.D_SHARP.createMutableClone().setOctave(6).getHertz())),

                        new Assertion<>(29, Math.round(Notes.B_FLAT.createMutableClone().setOctave(0).getHertz())),
                        new Assertion<>(28, Math.round(Notes.B_DOUBLE_FLAT.createMutableClone().setOctave(0).getHertz()))
                )
        );
    }
}
