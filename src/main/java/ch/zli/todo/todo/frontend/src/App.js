import React from "react";
import {
    BrowserRouter as Router,
    Switch,
    Route,
    Link
} from "react-router-dom";
import UserList from "./User/UserList";
import EditUser from "./User/editUser";
import SignUp from "./SignUp";
import SignIn from "./SignIn";
import AddUser from "./User/AddUser";

function App() {
    return (
        <div>
            <Router>
                <Switch>
                    <Route path="/editUser/:id" component={EditUser}/>
                    <Route path={'/users'} component={UserList}/>
                    <Route path={'/addUser'} component={AddUser}/>
                    <Route path={'/signUp'} component={SignUp}/>
                    <Route path={'/'} component={SignIn}/>
                    <Route path="/editTask/:id" component={EditUser}/>
                    <Route path={'/tasks'} component={UserList}/>
                    <Route path={'/addTask'} component={AddUser}/>
                </Switch>
            </Router>
        </div>
    );
}

export default App;