const e = require('express')
const neDB = require('../configurations/database')
const api = {}


api.findAll = (request, response) => {

    neDB.find({}).sort({name: 1}).exec( (exception, customers) => {

        if(exception) {

            const sentence = "Ops, deu ruim na tentativa de listar os customers!!"

            console.log("Ops, deu ruim na tentativa de listar os customers!!", exception)
            response.status(exception.status | 400)
            response.json({"mensagem": sentence});
        }

        response.json(customers);
    })
}

api.save = (request, response) => {

    const canonical = request.body   
    
    neDB.insert(canonical, (exception, customer) => {


        if(exception) {
            console.log("Ops, deu ruim na tentativa de inserir!!", exception);
        }    

        response.json(customer);
        response.status(201);
    })
}

module.exports = api