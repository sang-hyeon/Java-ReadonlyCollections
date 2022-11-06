package com.esheich.readonlycollections;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Collection;
import java.util.Hashtable;
import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.Test;

public class GenericReadOnlyMapTests {

    @Test
    void get_keys() {

        // Arrange
        var source = new Hashtable<String, String>();
        source.put("a", "a");
        source.put("b", "b");
        source.put("c", "c");

        Set<String> expectedKeys = source.keySet();
        var sut = new GenericReadOnlyMap<String, String>(source);

        // Act
        Set<String> actualKeys = sut.keySet();

        // Assert
        assertThat(actualKeys).isEqualTo(expectedKeys);
    }

    @Test
    void get_values() {

        // Arrange
        var source = new Hashtable<String, String>();
        source.put("a", "a");
        source.put("b", "b");
        source.put("c", "c");

        Collection<String> expectedValues = source.values();
        var sut = new GenericReadOnlyMap<String, String>(source);

        // Act
        ReadOnlyCollection<String> actualValues = sut.values();

        // Assert
        assertThat(actualValues).isEqualTo(expectedValues);
    }

    @Test
    void does_contain_key() {

        // Arrange
        var givenKey = "a";
        var source = new Hashtable<String, String>();
        source.put(givenKey, "a");
        source.put("b", "b");
        source.put("c", "c");

        var sut = new GenericReadOnlyMap<String, String>(source);

        // Act
        var doesContain = sut.containsKey(givenKey);

        // Assert
        assertThat(doesContain).isTrue();
    }

    @Test
    void does_not_contain_key() {

        // Arrange
        var source = new Hashtable<String, String>();
        var sut = new GenericReadOnlyMap<String, String>(source);

        // Act
        var doesContain = sut.containsKey("a");

        // Assert
        assertThat(doesContain).isFalse();
    }

    @Test
    void get_value_by_given_key() {

        // Arrange
        var givenKey = "a";
        var expectedValue = "b";
        var source = new Hashtable<String, String>();
        source.put("a", "a");
        source.put("b", "b");
        source.put(givenKey, expectedValue);

        var sut = new GenericReadOnlyMap<String, String>(source);

        // Act
        var actualValue = sut.getValue(givenKey);

        // Assert
        assertThat(actualValue).isEqualTo(expectedValue);
    }

    @Test
    void try_get_value_by_given_key_if_exists() {

        // Arrange
        var givenKey = "a";
        var expectedValue = "b";
        var source = new Hashtable<String, String>();
        source.put("a", "a");
        source.put("b", "b");
        source.put(givenKey, expectedValue);

        var sut = new GenericReadOnlyMap<String, String>(source);

        // Act
        Optional<String> actualValue = sut.tryGetValue(givenKey);

        // Assert
        assertThat(actualValue.get()).isEqualTo(expectedValue);
    }

    @Test
    void try_get_empty_value_by_given_key_if_doesnt_exist() {

        // Arrange
        var source = new Hashtable<String, String>();
        source.put("a", "a");
        source.put("b", "b");

        var sut = new GenericReadOnlyMap<String, String>(source);

        // Act
        Optional<String> actualValue = sut.tryGetValue("kk");

        // Assert
        assertThat(actualValue).isEmpty();
    }
}
