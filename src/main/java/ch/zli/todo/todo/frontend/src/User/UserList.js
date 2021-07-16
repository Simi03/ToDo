import React, {Component, useEffect, useState} from 'react';
import {Table, Button, Form} from 'react-bootstrap';
import axios from "axios";
import {Link} from "react-router-dom";

function UserList() {

    const [users, setUsers] = useState([]);

    let count=0;

    const getUsers = () => {
        axios.get("/user")
            .then((res) => {
                setUsers(res.data);
            })
            .catch((err) => {
                console.log(err);
            });
    }

    useEffect( () => {
        getUsers()
    }, [users]);


    const deleteUser = (id) => {
        axios.delete("/user/" + id)
            .catch((err) => {
                console.log(err);
            });
        getUsers();
       window.location.reload();
    }

    const userList = users.map(user => {
        return <Table striped bordered hover>
            <thead>
            <tr>
                <th>#</th>
                <th>Username</th>
                <th>Password</th>
                <th>Update</th>
                <th>Delete</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>{user.id}</td>
                <td>{user.username}</td>
                <td>{user.password}</td>
                <td>
                    <Link to={"/editUser/"+user.id} className="btn btn-warning">Update</Link>
                </td>
                <td>
                    <Button  variant="danger" onClick={() => deleteUser(user.id)}>Delete</Button>
                </td>
            </tr>
            </tbody>
        </Table>
    });
    return (
        <div>
            {userList}
            <div className="float-right">
                <Link to={"/addUser"} className="btn btn-primary  btn-lg btn-block">Add User</Link>
            </div>
            <br/>
            <div className="float-right">
                <Link  to={"/SportList"} className="btn btn-info  btn-lg btn-block">Tasks</Link>
            </div>
        </div>
    )};


export default UserList;