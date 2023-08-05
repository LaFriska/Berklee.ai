package com.friska.jnotes.test;

import com.friska.jnotes.core.notes.Alteration;
import com.friska.jnotes.core.notes.Note;
import com.friska.jnotes.core.notes.BaseNote;
import com.friska.jnotes.core.notes.Notes;
import com.friska.jnotes.test.testutil.Assertion;
import com.friska.jnotes.test.testutil.Suite;

public class NotesTest {

    protected static void comparison(){
        TestMain.test.addSuite(
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

        TestMain.test.addSuite(
                new Suite("Notes.Comparison.Equivalency").addAssertions(
                        new Assertion<>(true, Notes.A.equals(new Note(BaseNote.A))),
                        new Assertion<>(true, Notes.B_DOUBLE_SHARP.equals(new Note(BaseNote.B, Alteration.DOUBLE_SHARP))),
                        new Assertion<>(false, Notes.B_SHARP.equals(new Note(BaseNote.B, Alteration.DOUBLE_SHARP))),
                        new Assertion<>(true, Notes.C.equals(new Note(BaseNote.C))),
                        new Assertion<>(true, Notes.C_SHARP.equals(new Note(BaseNote.C, Alteration.SHARP))),
                        new Assertion<>(false, Notes.E.equals(new Note(BaseNote.D, Alteration.DOUBLE_SHARP))),
                        new Assertion<>(false, Notes.G_FLAT.equals(new Note(BaseNote.A, Alteration.SHARP))),
                        new Assertion<>(false, Notes.F_FLAT.equals(new Note(BaseNote.D, Alteration.DOUBLE_SHARP))),
                        new Assertion<>(true, Notes.C_DOUBLE_FLAT.equals(new Note(BaseNote.C, Alteration.DOUBLE_FLAT)))
                )
        );

        TestMain.test.addSuite(
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
        TestMain.test.addSuite(
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

        TestMain.test.addSuite(
                new Suite("Notes.Pitch.Spelling").addAssertions(
                        new Assertion<>("C♯", Notes.C_SHARP.getSpelling()),
                        new Assertion<>("D\uD834\uDD2B", Notes.D_DOUBLE_FLAT.getSpelling()),
                        new Assertion<>("E♭", Notes.E_FLAT.getSpelling()),
                        new Assertion<>("F\uD834\uDD2A", Notes.F_DOUBLE_SHARP.getSpelling()),
                        new Assertion<>("G", Notes.G.getSpelling())
                )
        );
    }

    protected static void misc(){
        TestMain.test.addSuites(
                new Suite("Notes.Misc.BaseNotes").addAssertions(
                        new Assertion<>(1, Notes.A.setOctave(0).getBaseNoteLabel()),
                        new Assertion<>(2, Notes.B.setOctave(0).getBaseNoteLabel()),
                        new Assertion<>(3, Notes.C.setOctave(1).getBaseNoteLabel()),
                        new Assertion<>(4, Notes.D.setOctave(1).getBaseNoteLabel()),
                        new Assertion<>(8, Notes.A.setOctave(1).getBaseNoteLabel()),
                        new Assertion<>(9, Notes.B.setOctave(1).getBaseNoteLabel()),
                        new Assertion<>(12, Notes.E.setOctave(2).getBaseNoteLabel()),
                        new Assertion<>(43, Notes.A.setOctave(6).getBaseNoteLabel()),
                        new Assertion<>(34, Notes.F.setOctave(5).getBaseNoteLabel()),
                        new Assertion<>(47, Notes.E.setOctave(7).getBaseNoteLabel()),
                        new Assertion<>(15, Notes.A.setOctave(2).getBaseNoteLabel())
                ),
                new Suite("Notes.Misc.getIntervals").addAssertions(

                )
        );
    }
}
