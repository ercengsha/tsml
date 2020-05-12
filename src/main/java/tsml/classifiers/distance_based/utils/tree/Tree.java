package tsml.classifiers.distance_based.utils.tree;

/**
 * Purpose: // todo - docs - type the purpose of the code here
 * <p>
 * Contributors: goastler
 */

public interface Tree<A> {

    TreeNode<A> getRoot();

    void setRoot(TreeNode<A> root);

    int size();

    int height();

    void clear();
}
