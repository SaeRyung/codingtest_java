package lectures.chap02.section01.tree;

import com.sun.jdi.connect.Connector;
import com.sun.source.tree.Tree;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class TreeTraversalTest {
    private static TreeTraversal.Node<String> root;
    private TreeTraversal<String> treeTraversal;

    @BeforeAll
    static void createTree() {
        root = new TreeTraversal.Node<>("A");
        root.left = new TreeTraversal.Node<>("B");
        root.right = new TreeTraversal.Node<>("C");
        root.left.left = new TreeTraversal.Node<>("D");
        root.left.right = new TreeTraversal.Node<>("E");
        root.right.left = new TreeTraversal.Node<>("F");
        root.right.right = new TreeTraversal.Node<>("G");
    }

    @BeforeEach
    void setUp() {
        treeTraversal = new TreeTraversal();
    }

    static Stream<Arguments> providePreOrderTestCases() {
        return Stream.of(
                Arguments.arguments(root.left, Arrays.asList("B", "D", "E")),
                Arguments.arguments(root.right, Arrays.asList("C", "F", "G")),
                Arguments.arguments(root, Arrays.asList("A", "B", "D", "E", "C", "F", "G"))
        );
    }

    @DisplayName("전위 순회 테스트")
    @ParameterizedTest
    @MethodSource("providePreOrderTestCases")
    void testPreOrder(TreeTraversal.Node<String> root, List<String> expected) {
        List<String> result = treeTraversal.preOrder(root);
        Assertions.assertEquals(expected, result);
    }


    static Stream<Arguments> provideInOrderTestCases() {
        return Stream.of(
                Arguments.arguments(root.left, Arrays.asList("D", "B", "E")),
                Arguments.arguments(root.right, Arrays.asList("F", "C", "G")),
                Arguments.arguments(root, Arrays.asList("D", "B", "E", "A", "F", "C", "G"))
        );
    }

    @DisplayName("중위 순회 테스트")
    @ParameterizedTest
    @MethodSource("provideInOrderTestCases")
    void testInOrder(TreeTraversal.Node<String> root, List<String> expected) {
        List<String> result = treeTraversal.inOrder(root);
        Assertions.assertEquals(expected, result);
    }

    static Stream<Arguments> providePostOrderTestCases() {
        return Stream.of(
                Arguments.arguments(root.left, Arrays.asList("D", "E", "B")),
                Arguments.arguments(root.right, Arrays.asList("F", "G", "C")),
                Arguments.arguments(root, Arrays.asList("D", "E", "B", "F", "G", "C", "A"))
        );
    }

    @DisplayName("후위 순회 테스트")
    @ParameterizedTest
    @MethodSource("providePostOrderTestCases")
    void testPostOrder(TreeTraversal.Node<String> root, List<String> expected) {
        List<String> result = treeTraversal.postOrder(root);
        Assertions.assertEquals(expected, result);
    }

}