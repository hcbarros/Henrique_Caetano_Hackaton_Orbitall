const e = require('express')
const neDB = require('../configurations/database')
const api = {}


api.findAll = (request, response) => {

    neDB.find({}).exec( (exception, cards) => {

        if(exception) {

            const sentence = "Ops, deu ruim na tentativa de listar os cards!!"

            console.log("Ops, deu ruim na tentativa de listar os cards!!", exception)
            response.status(exception.status | 400)
            response.json({"mensagem": sentence});
        }

        response.json(cards);
    })
}

api.save = (request, response) => {

    const canonical = request.body   
    
    neDB.insert(canonical, (exception, cards) => {


        if(exception) {
            console.log("Ops, deu ruim na tentativa de inserir!!", exception);
        }    

        response.json(cards);
        response.status(201);
    })
}

api.findOne = (request, response) => {
       
    neDB.findOne({_id: request.params.id}, (exception, card) => {

        if(exception) {
            console.log("Ops, deu ruim na tentativa de exibir!!", exception);
        }    

        response.json(card);
        response.status(201);
    })
}

api.delete = (request, response) => {
       
    neDB.remove({_id: request.params.id}, (exception, card) => {

        if(exception) {
            console.log("Ops, deu ruim na tentativa de exibir!!", exception);
        }    

        response.json(card);
        response.status(201);
    })
}

api.put = (request, response) => {

    const canonical = request.body   
       
    neDB.update({_id: request.params.id}, canonical, (exception, card) => {

        if(exception) {
            console.log("Ops, deu ruim na tentativa de exibir!!", exception);
        }    

        response.json(card);
        response.status(201);
    })
}


module.exports = api
