package domain;

import java.util.List;

/**
 * Description :
 *
 * @author Eric L SHU
 * @date 2022-10-06 7:18 PM
 * @since jdk-11.0.14
 */
public class NaryNode
{
    public int val;
    public List<NaryNode> children;

    public NaryNode()
    {
    }

    public NaryNode(int _val)
    {
        val = _val;
    }

    public NaryNode(int _val, List<NaryNode> _children)
    {
        val = _val;
        children = _children;
    }
}
