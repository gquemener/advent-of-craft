Here's my take:

- explicitly describe the different tested behaviors (`it_should_be_commentable`, `it_should_provide_related_comments`, `it_should_forbid_spam`)
- express object behavior as method name (comment vs addComment)
- do not leak comments structure within the Article class (aka provide a Comment object to the comment method)
