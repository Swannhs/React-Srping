import React from "react";
import { Link } from "react-router-dom";

const CreateProjectButton = () => {
  return (
    <React.Fragment>
      <Link to="/post" className="btn btn-lg btn-info">
        Create a Post
      </Link>
    </React.Fragment>
  );
};

export default CreateProjectButton;
