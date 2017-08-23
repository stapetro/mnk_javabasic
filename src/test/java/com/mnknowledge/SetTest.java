package com.mnknowledge;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.EnumSet;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Consumer;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 * Test Set APIs.
 *
 * @author Stanislav Petrov
 */
public class SetTest {
    private final static Logger LOGGER = Logger.getLogger(SetTest.class.getName());

    @Test
    public void testSet() {
        String name = "Stan";
        String name1 = "Valentin";
        String name2 = "Miroljub";
        final int expectedUniqNameSize = 3;
        List<String> duplicateNames = List.of(name, name1, name2, name1, name, name, name2, name1, name2);
        try {
            duplicateNames.add(name);
        } catch (UnsupportedOperationException ex) {
            LOGGER.log(Level.WARNING, "Add to an immutable collection", ex);
        }

        /*
         * bad example because you are working by implementation
         * It's better to work by an interface (by design, by contract)
         */
        HashSet<String> uniqueNames = new HashSet<>(duplicateNames);
        NavigableSet<String> sortedUniqNames = duplicateNames.stream().collect(Collectors.toCollection(TreeSet::new));
        Set<String> insertionOrderedNames = new LinkedHashSet<>(duplicateNames);
        for (String currName : uniqueNames) {
            System.out.println(currName);
        }
        Consumer<String> nameConsumer = currName -> System.out.println(currName);
        Consumer<String> nameConsumer1 = System.out::println;
        uniqueNames.forEach(nameConsumer);
        uniqueNames.forEach(nameConsumer1);

        Assertions.assertThat(uniqueNames).hasSize(expectedUniqNameSize);
        Assertions.assertThat(sortedUniqNames).hasSize(expectedUniqNameSize);
        Assertions.assertThat(sortedUniqNames).containsSequence(name2, name, name1);
        Assertions.assertThat(insertionOrderedNames).hasSize(expectedUniqNameSize);
        Assertions.assertThat(insertionOrderedNames).containsSequence(name, name1, name2);

        StringBuilder output = new StringBuilder();
        output.append("Duplicate names: ").append(duplicateNames).append("\nHashSet: ").append(uniqueNames).append("\nTreeSet: ").append(sortedUniqNames).append("\nLinkedHashSet: ").append(insertionOrderedNames);
        System.out.println(output);
    }

    @Test
    public void testEnumSet() {
        Flag.ALL_OPTS.stream().filter(option -> option != Flag.UPPERCASE).forEach(System.out::println);
    }

    public enum Flag {
        UPPERCASE, REVERSE, FULL_STOP, EMPHASISE;

        public static final EnumSet<Flag> ALL_OPTS = EnumSet.allOf(Flag.class);
    }

}
