package asl
 import _root_.scala.collection.mutable.HashMap

 import _root_.akka.actor.typed.{ActorRef, Behavior, SupervisorStrategy}
 import _root_.akka.actor.typed.scaladsl.{ActorContext, Behaviors, Routers}
 import java.util.logging.Logger
 import _root_.scala.util.Failure
 import _root_.scala.util.Success
 import _root_.akka.util.Timeout
 import _root_.scala.concurrent.duration._
 import _root_.akka.actor.typed.scaladsl.AskPattern._
 import _root_.scala.language.implicitConversions
 import _root_.scala.concurrent.{Await, Future}
 import _root_.scala.jdk.CollectionConverters._
 import std.converters._

 import scala.util.Random
 import bb._
 import infrastructure._
 import bb.expstyla.exp._
 import std.{AgentCommunicationLayer, DefaultCommunications}

 class integrity  (coms: AgentCommunicationLayer = new  DefaultCommunications,
                                     beliefBaseFactory: IBeliefBaseFactory = new StylaBeliefBaseFactory)
                      extends IntentionalAgentFactory {


 object Intention {

       def apply(p_executionContext: ExecutionContext): Behavior[ISubGoalMessage] = Behaviors.setup { context =>

         Behaviors.receive {
         (context, message) =>

          implicit val executionContext = p_executionContext.copy(intention = context, src = message.source)

         message match {
            case SubGoalMessage(_,_,r) =>
               message.goal match {

                   case integrity.this.adopt_test_integrity_3 =>
                     integrity.this.adopt_test_integrity_3.execute(message.params.asInstanceOf[Parameters])

                   case integrity.this.adopt_achievement_getnames_0 =>
                     integrity.this.adopt_achievement_getnames_0.execute(message.params.asInstanceOf[Parameters])

                   case integrity.this.adopt_achievement_update_integrity_2 =>
                     integrity.this.adopt_achievement_update_integrity_2.execute(message.params.asInstanceOf[Parameters])

                   case integrity.this.adopt_achievement_get_principle_intention_3 =>
                     integrity.this.adopt_achievement_get_principle_intention_3.execute(message.params.asInstanceOf[Parameters])

                   case integrity.this.adopt_achievement_get_weight_3 =>
                     integrity.this.adopt_achievement_get_weight_3.execute(message.params.asInstanceOf[Parameters])

                   case integrity.this.adopt_achievement_assign_intention_3 =>
                     integrity.this.adopt_achievement_assign_intention_3.execute(message.params.asInstanceOf[Parameters])

                   case integrity.this.adopt_achievement_assign_value_2 =>
                     integrity.this.adopt_achievement_assign_value_2.execute(message.params.asInstanceOf[Parameters])

                   case integrity.this.adopt_achievement_distanceSum_3 =>
                     integrity.this.adopt_achievement_distanceSum_3.execute(message.params.asInstanceOf[Parameters])

                   case integrity.this.adopt_achievement_distanceMax_3 =>
                     integrity.this.adopt_achievement_distanceMax_3.execute(message.params.asInstanceOf[Parameters])

                   case integrity.this.adopt_achievement_normalizedDistance_2 =>
                     integrity.this.adopt_achievement_normalizedDistance_2.execute(message.params.asInstanceOf[Parameters])

                   case integrity.this.adopt_achievement_renew_info_3 =>
                     integrity.this.adopt_achievement_renew_info_3.execute(message.params.asInstanceOf[Parameters])


           case _ =>
             context.log.error("This actor can not handle goal of type {}", message.goal)
         }
           r match {
                 case a : AkkaMessageSource => 
                   a.src ! IntentionDoneMessage(AkkaMessageSource(executionContext.agent.self))
                 case DummyMessageSource(_) => 
                   context.log.error("Intention Done!")
               }

               Behaviors.same
             case InitEndMessage(r) =>
               Behaviors.stopped
       }
      }
     }
     }

 override def agentBuilder: Agent = new Agent()
 class Agent extends IAgent {

         override def agent_type: String = "integrity"

         var vars = VarMap()

         def initGoals()(implicit executionContext: ExecutionContext) = List[StructTerm](
                     StructTerm("getnames",Seq[GenericTerm](  ))


         )

         def initBeliefs()(implicit executionContext: ExecutionContext) = List[StructTerm](
                     StructTerm("agent",Seq[GenericTerm](StructTerm("damian",Seq[GenericTerm]())))
           ,
            StructTerm("agent",Seq[GenericTerm](StructTerm("tom",Seq[GenericTerm]())))
           ,
            StructTerm("agent",Seq[GenericTerm](StructTerm("paula",Seq[GenericTerm]())))
           ,
            StructTerm("trustor",Seq[GenericTerm](StructTerm("anna",Seq[GenericTerm]())))
           ,
            StructTerm("principle",Seq[GenericTerm](StructTerm("gardening",Seq[GenericTerm]()),StructTerm("honesty",Seq[GenericTerm]()),DoubleTerm(0.8)))
           ,
            StructTerm("principle",Seq[GenericTerm](StructTerm("gardening",Seq[GenericTerm]()),StructTerm("reliability",Seq[GenericTerm]()),DoubleTerm(0.7)))
           ,
            StructTerm("principle",Seq[GenericTerm](StructTerm("cleaning",Seq[GenericTerm]()),StructTerm("honesty",Seq[GenericTerm]()),DoubleTerm(0.3)))
           ,
            StructTerm("principle",Seq[GenericTerm](StructTerm("cleaning",Seq[GenericTerm]()),StructTerm("reliability",Seq[GenericTerm]()),DoubleTerm(0.9)))
           ,
            StructTerm("weight",Seq[GenericTerm](StructTerm("honesty",Seq[GenericTerm]()),DoubleTerm(0.6)))
           ,
            StructTerm("weight",Seq[GenericTerm](StructTerm("reliability",Seq[GenericTerm]()),DoubleTerm(0.4)))
           ,
            StructTerm("value",Seq[GenericTerm](StructTerm("damian",Seq[GenericTerm]()),StructTerm("honesty",Seq[GenericTerm]()),DoubleTerm(0.7)))
           ,
            StructTerm("value",Seq[GenericTerm](StructTerm("damian",Seq[GenericTerm]()),StructTerm("reliability",Seq[GenericTerm]()),DoubleTerm(0.8)))
           ,
            StructTerm("value",Seq[GenericTerm](StructTerm("paula",Seq[GenericTerm]()),StructTerm("honesty",Seq[GenericTerm]()),DoubleTerm(0.5)))
           ,
            StructTerm("value",Seq[GenericTerm](StructTerm("paula",Seq[GenericTerm]()),StructTerm("reliability",Seq[GenericTerm]()),DoubleTerm(0.9)))
           ,
            StructTerm("value",Seq[GenericTerm](StructTerm("tom",Seq[GenericTerm]()),StructTerm("honesty",Seq[GenericTerm]()),DoubleTerm(0.9)))
           ,
            StructTerm("value",Seq[GenericTerm](StructTerm("tom",Seq[GenericTerm]()),StructTerm("reliability",Seq[GenericTerm]()),DoubleTerm(0.6)))
           ,
            StructTerm("intention",Seq[GenericTerm](StructTerm("damian",Seq[GenericTerm]()),StructTerm("gardening",Seq[GenericTerm]())))
           ,
            StructTerm("intention",Seq[GenericTerm](StructTerm("damian",Seq[GenericTerm]()),StructTerm("cleaning",Seq[GenericTerm]())))
           ,
            StructTerm("intention",Seq[GenericTerm](StructTerm("paula",Seq[GenericTerm]()),StructTerm("gardening",Seq[GenericTerm]())))
           ,
            StructTerm("intention",Seq[GenericTerm](StructTerm("paula",Seq[GenericTerm]()),StructTerm("cleaning",Seq[GenericTerm]())))
           ,
            StructTerm("intention",Seq[GenericTerm](StructTerm("tom",Seq[GenericTerm]()),StructTerm("gardening",Seq[GenericTerm]())))
           ,
            StructTerm("intention",Seq[GenericTerm](StructTerm("tom",Seq[GenericTerm]()),StructTerm("cleaning",Seq[GenericTerm]())))
           ,
            StructTerm("relationship",Seq[GenericTerm](StructTerm("anna",Seq[GenericTerm]()),StructTerm("tom",Seq[GenericTerm]()),StructTerm("friend",Seq[GenericTerm]())))
           ,
            StructTerm("relationship",Seq[GenericTerm](StructTerm("anna",Seq[GenericTerm]()),StructTerm("paula",Seq[GenericTerm]()),StructTerm("collegue",Seq[GenericTerm]())))
           ,
            StructTerm("relationship",Seq[GenericTerm](StructTerm("anna",Seq[GenericTerm]()),StructTerm("damian",Seq[GenericTerm]()),StructTerm("acquaintance",Seq[GenericTerm]())))
           ,
            StructTerm("relationship_strength",Seq[GenericTerm](StructTerm("anna",Seq[GenericTerm]()),StructTerm("tom",Seq[GenericTerm]()),DoubleTerm(0.9)))
           ,
            StructTerm("relationship_strength",Seq[GenericTerm](StructTerm("anna",Seq[GenericTerm]()),StructTerm("paula",Seq[GenericTerm]()),DoubleTerm(0.6)))
           ,
            StructTerm("relationship_strength",Seq[GenericTerm](StructTerm("anna",Seq[GenericTerm]()),StructTerm("damian",Seq[GenericTerm]()),DoubleTerm(0.2)))
           ,
            StructTerm("weight_relationship",Seq[GenericTerm](StructTerm("friend",Seq[GenericTerm]()),DoubleTerm(0.8)))
           ,
            StructTerm("weight_relationship",Seq[GenericTerm](StructTerm("acquaintance",Seq[GenericTerm]()),DoubleTerm(0.5)))
           ,
            StructTerm("weight_relationship",Seq[GenericTerm](StructTerm("neighbour",Seq[GenericTerm]()),DoubleTerm(0.6)))
           ,
            StructTerm("weight_relationship",Seq[GenericTerm](StructTerm("collegue",Seq[GenericTerm]()),DoubleTerm(0.7)))
           ,
            StructTerm("threshold",Seq[GenericTerm](DoubleTerm(0.7)))
           ,
            StructTerm(":-",Seq[GenericTerm](StructTerm("missing_or_zero_value",Seq[GenericTerm](vars("Agent"),vars("Principle"),vars("Value"))),StructTerm(";",Seq[GenericTerm](StructTerm("value",Seq[GenericTerm](vars("Agent"),vars("Principle"),IntTerm(0))),StructTerm("not",Seq[GenericTerm](StructTerm("value",Seq[GenericTerm](vars("Agent"),vars("Principle"),vars("_")))))))))
           ,
            StructTerm("competence_provider_agent",Seq[GenericTerm](StringTerm("competence")))
           ,
            StructTerm("benevolence_provider_agent",Seq[GenericTerm](StringTerm("benevolence")))
           ,
            StructTerm("integrity_provider_agent",Seq[GenericTerm](StringTerm("integrity")))
           ,
            StructTerm("decision_maker_agent",Seq[GenericTerm](StringTerm("decisionCosinesim")))
           ,
            StructTerm("trutsworthiness_provider_agent",Seq[GenericTerm](StringTerm("trustworthiness")))


         )

         def planApplicabilities()(implicit executionContext: ExecutionContext) = List[StructTerm](

                 )



      def apply(name: String, yellowPages: IYellowPages, MAS: ActorRef[IMessage], parent: IMessageSource): Behavior[IMessage] = {
           Behaviors.setup { context =>
             val yp: IYellowPages = yellowPages
             val bb: IBeliefBase[GenericTerm] = beliefBaseFactory()
             implicit val executionContext: ExecutionContext = ExecutionContext(
                            name = name,
                            agentType = agent_type,
                            agent = context,
                            yellowPages = yp,
                            beliefBase = bb,
                            logger = context.log,
                            goalParser = GoalParser,
                            parent = parent
                          )
             bb.assert(initBeliefs)
             bb.assert(planApplicabilities)

         val initiator = context.spawn(Intention(executionContext), "initiator")

         MAS ! ReadyMessage(context.self)
         Behaviors.receive {
           (context, message) =>
             message match {
               case StartMessage() =>


                 implicit val timeout: Timeout = 99999.seconds
                 implicit val ec = context.executionContext
                 implicit val scheduler = context.system.scheduler


                 //              initGoals.foreach( tuple => initiator ! SubGoalMessage(tuple._1,tuple._2,context.self))
                 initGoals.foreach(struct => {


                   val result: Future[IMessage] = initiator.ask[IMessage](ref => {
                     val subGoal = GoalParser.create_goal_message(struct, AkkaMessageSource(ref))
                     if (subGoal.isDefined)
                       subGoal.get
                     else
                       throw new RuntimeException(s"No plan for initial goal $struct")
                     }
                   )


                   //result.onComplete {
                   //  case Success(IntentionDoneMessage(r)) => IntentionDoneMessage(r)
                   //  case Failure(_) => IntentionErrorMessage(src = null)
                   //}

                   //Await.result(result, timeout.duration)

                   val res = Await.result(result, timeout.duration)

                   if(!res.isInstanceOf[IntentionDoneMessage]) {
                     throw new RuntimeException(s"Issue with initial goal $struct")
                     context.system.terminate()
                   }

                   //                context.ask[ISubGoalMessage, IMessage](initiator, ref => SubGoalMessage(tuple._1, tuple._2,name, ref)) {
                   //                  case Success(IntentionDoneMessage(_, _)) => IntentionDoneMessage()
                   //                  case Failure(_) => IntentionErrorMessage()
                   //                }
                 }
                 )

                 initiator ! InitEndMessage(context.self)
                 normal_behavior(MAS)

               //            case InitEndMessage(_) =>
               //              context.log.debug(f"$name: I have started, switching behavior")
               //              normal_behavior()
             }

         }
       }
     }

     def normal_behavior(MAS: ActorRef[IMessage])(implicit executionContext: ExecutionContext): Behavior[IMessage] = {
       Behaviors.setup { context =>

         val pool = Routers.pool(poolSize = 8)(
           Behaviors.supervise(Intention(executionContext)).onFailure[Exception](SupervisorStrategy.restart))

         val router = context.spawn(pool, "intention-pool")
         //MAS ! ReadyMessage(context.self)
         Behaviors.receive {
           (context, message) =>
             message match {
               case IntentionDoneMessage(s) =>
                 context.log.debug(f"${executionContext.name}: an intention was done by $s")
               case IntentionErrorMessage(c,s) =>
                 context.log.debug(f"${executionContext.name}: an intention was done by $s: $c")
               case SubGoalMessage(_, _, _) =>
                 router ! message.asInstanceOf[SubGoalMessage]
               case GoalMessage(m, ref) =>
                 m match {
                   case t: StructTerm =>
                     val subGoal = GoalParser.create_goal_message(t, ref)

                     if (subGoal.isDefined)
                       context.self ! subGoal.get
                     else
                       ref.asInstanceOf[AkkaMessageSource].src ! IntentionErrorMessage(NoPlanMessage(),AkkaMessageSource(executionContext.agent.self))


                 }

                case AskMessage(m, ref) =>
                                m match {
                                  case t: StructTerm =>
                                    val subGoal = GoalParser.create_test_message(t, ref)

                                    if (subGoal.isDefined)
                                      context.self ! subGoal.get
                                    else
                                      ref.asInstanceOf[AkkaMessageSource].src ! IntentionErrorMessage(NoPlanMessage(),AkkaMessageSource(executionContext.agent.self))
                                }
             case BeliefMessage(m, ref) =>
                  m match {
                    case t: StructTerm =>
                    if(executionContext.beliefBase.assertOne(t)) {
                      val subGoal = GoalParser.create_belief_message(t, ref)

                      if (subGoal.isDefined)
                        context.self ! subGoal.get
                    }
                  }

              case UnBeliefMessage(m, ref) =>
                   m match {
                     case t: StructTerm =>
                     if(executionContext.beliefBase.retractOne(t)) {
                       val subGoal = GoalParser.create_unbelief_message(t, ref)

                       if (subGoal.isDefined)
                         context.self ! subGoal.get
                     }
                   }
             }
             Behaviors.same
         }
       }
     }
   }



   object GoalParser extends IAgentGoalParser {
        override def create_goal_message(t: StructTerm, ref: IMessageSource) (implicit executionContext: ExecutionContext): Option[SubGoalMessage] = {
                   
                                   if(t.matchOnlyFunctorAndArity("getnames",0)) {
                                     val args: Parameters = Parameters(t.terms.toList)
                                     Option(SubGoalMessage(adopt_achievement_getnames_0, args, ref))
                                   } else  
                                   if(t.matchOnlyFunctorAndArity("update_integrity",2)) {
                                     val args: Parameters = Parameters(t.terms.toList)
                                     Option(SubGoalMessage(adopt_achievement_update_integrity_2, args, ref))
                                   } else  
                                   if(t.matchOnlyFunctorAndArity("get_principle_intention",3)) {
                                     val args: Parameters = Parameters(t.terms.toList)
                                     Option(SubGoalMessage(adopt_achievement_get_principle_intention_3, args, ref))
                                   } else  
                                   if(t.matchOnlyFunctorAndArity("get_weight",3)) {
                                     val args: Parameters = Parameters(t.terms.toList)
                                     Option(SubGoalMessage(adopt_achievement_get_weight_3, args, ref))
                                   } else  
                                   if(t.matchOnlyFunctorAndArity("assign_intention",3)) {
                                     val args: Parameters = Parameters(t.terms.toList)
                                     Option(SubGoalMessage(adopt_achievement_assign_intention_3, args, ref))
                                   } else  
                                   if(t.matchOnlyFunctorAndArity("assign_value",2)) {
                                     val args: Parameters = Parameters(t.terms.toList)
                                     Option(SubGoalMessage(adopt_achievement_assign_value_2, args, ref))
                                   } else  
                                   if(t.matchOnlyFunctorAndArity("distanceSum",3)) {
                                     val args: Parameters = Parameters(t.terms.toList)
                                     Option(SubGoalMessage(adopt_achievement_distanceSum_3, args, ref))
                                   } else  
                                   if(t.matchOnlyFunctorAndArity("distanceMax",3)) {
                                     val args: Parameters = Parameters(t.terms.toList)
                                     Option(SubGoalMessage(adopt_achievement_distanceMax_3, args, ref))
                                   } else  
                                   if(t.matchOnlyFunctorAndArity("normalizedDistance",2)) {
                                     val args: Parameters = Parameters(t.terms.toList)
                                     Option(SubGoalMessage(adopt_achievement_normalizedDistance_2, args, ref))
                                   } else  
                                   if(t.matchOnlyFunctorAndArity("renew_info",3)) {
                                     val args: Parameters = Parameters(t.terms.toList)
                                     Option(SubGoalMessage(adopt_achievement_renew_info_3, args, ref))
                                   } else   {
                    Option.empty[SubGoalMessage]
                    }

                }

        override def create_belief_message(t: StructTerm, ref: IMessageSource) (implicit executionContext: ExecutionContext): Option[SubGoalMessage] = {
                              {
                    Option.empty[SubGoalMessage]
                    }

                }

         override def create_test_message(t: StructTerm, ref: IMessageSource) (implicit executionContext: ExecutionContext): Option[SubGoalMessage] = {
                                                   if(t.matchOnlyFunctorAndArity("integrity",3)) {
                                                     val args: Parameters = Parameters(t.terms.toList)
                                                     Option(SubGoalMessage(adopt_test_integrity_3, args, ref))
                                                   } else             {
                            Option.empty[SubGoalMessage]
                            }
                        }
          override def create_unbelief_message(t: StructTerm, ref: IMessageSource) (implicit executionContext: ExecutionContext): Option[SubGoalMessage] = {
                                               {
                                     Option.empty[SubGoalMessage]
                                     }
                                 }



        }


      object adopt_test_integrity_3 extends IGoal {

        def execute(params: Parameters) (implicit executionContext: ExecutionContext) : Unit = {
         var vars = VarMap()

         vars("Self").bind_to(StringTerm(executionContext.name))
         vars("Source").bind_to(StringTerm(executionContext.src.name))
         vars("Parent").bind_to(StringTerm(executionContext.parent.name))






                 //plan 0 start

                         vars.clear()
                         vars("Self").bind_to(StringTerm(executionContext.name))
                         vars("Source").bind_to(StringTerm(executionContext.src.name))
                         vars("Parent").bind_to(StringTerm(executionContext.parent.name))
                         vars +=(   "A" -> params.l_params(0))
                          vars +=(   "Goal" -> params.l_params(1))
                          vars +=(   "IScore" -> params.l_params(2))

                         val r0 = executionContext.beliefBase.query(StructTerm(",",Seq[GenericTerm](StructTerm(",",Seq[GenericTerm](StructTerm("integrity",Seq[GenericTerm](vars("A"),vars("Goal"),vars("IScore"))),StructTerm("decision_maker_agent",Seq[GenericTerm](vars("DMAgent"))))),StructTerm("trutsworthiness_provider_agent",Seq[GenericTerm](vars("Tagent"))))))

                         if (r0.result) {
                             r0.bindings foreach { case (k, v) =>
                            // vars += (k -> v.asInstanceOf[GenericTerm])
                                      vars(k).bind_to(v)
                             }
                             plan0(vars)
                             return
                          }

                          // plan 0 end



                 //plan 1 start

                         vars.clear()
                         vars("Self").bind_to(StringTerm(executionContext.name))
                         vars("Source").bind_to(StringTerm(executionContext.src.name))
                         vars("Parent").bind_to(StringTerm(executionContext.parent.name))
                         vars +=(   "A" -> params.l_params(0))
                          vars +=(   "Goal" -> params.l_params(1))
                          vars +=(   "IScore" -> params.l_params(2))

                         val r1 = executionContext.beliefBase.query(StructTerm("not",Seq[GenericTerm](StructTerm("integrity",Seq[GenericTerm](vars("A"),vars("Goal"),vars("_"))))))

                         if (r1.result) {
                             r1.bindings foreach { case (k, v) =>
                            // vars += (k -> v.asInstanceOf[GenericTerm])
                                      vars(k).bind_to(v)
                             }
                             plan1(vars)
                             return
                          }

                          // plan 1 end


             executionContext.src.asInstanceOf[AkkaMessageSource].address() ! IntentionErrorMessage(NoApplicablePlanMessage(),AkkaMessageSource(executionContext.agent.self))

        }


                      def plan0(vars: VarMap)(implicit executionContext: ExecutionContext): Unit = {

                                          PrimitiveAction.execute(PrimitiveAction.Parameters(() => coms.inform(vars("DMAgent"),StructTerm("integrity",Seq[GenericTerm](vars("A"),vars("Goal"),vars("IScore"))))))
                                          PrimitiveAction.execute(PrimitiveAction.Parameters(() => coms.inform(vars("Tagent"),StructTerm("integrity",Seq[GenericTerm](vars("A"),vars("Goal"),vars("Iscore"))))))


                     }
                      def plan1(vars: VarMap)(implicit executionContext: ExecutionContext): Unit = {

                                          adopt_achievement_update_integrity_2.execute(Parameters(List( vars("A") , vars("Goal")  )))


                     }


      }

      object adopt_achievement_getnames_0 extends IGoal {

        def execute(params: Parameters) (implicit executionContext: ExecutionContext) : Unit = {
         var vars = VarMap()

         vars("Self").bind_to(StringTerm(executionContext.name))
         vars("Source").bind_to(StringTerm(executionContext.src.name))
         vars("Parent").bind_to(StringTerm(executionContext.parent.name))






                 //plan 0 start

                         vars.clear()
                         vars("Self").bind_to(StringTerm(executionContext.name))
                         vars("Source").bind_to(StringTerm(executionContext.src.name))
                         vars("Parent").bind_to(StringTerm(executionContext.parent.name))
                             plan0(vars)
                             return
                          // plan 0 end


             executionContext.src.asInstanceOf[AkkaMessageSource].address() ! IntentionErrorMessage(NoApplicablePlanMessage(),AkkaMessageSource(executionContext.agent.self))

        }


                      def plan0(vars: VarMap)(implicit executionContext: ExecutionContext): Unit = {

                                          PrimitiveAction.execute(PrimitiveAction.Parameters(() => println(StringTerm("Starting integrity update for all agents."))))
                                               val ex_L19286 = executionContext.beliefBase.bufferedQuery( StructTerm("agent",Seq[GenericTerm](vars("L19286"))) )
                                               while (ex_L19286.hasNext) {
                                                   val sol_L19286 = ex_L19286.next
                                                   if(sol_L19286.result) {
                                                   vars += ("A" -> sol_L19286.bindings("L19286").asInstanceOf[GenericTerm])
                                                                       PrimitiveAction.execute(PrimitiveAction.Parameters(() => println( (StringTerm("Processing agent: ") + vars("A")) )))
                                                                            val ex_L76521 = executionContext.beliefBase.bufferedQuery( StructTerm("intention",Seq[GenericTerm](vars("A"),vars("L76521"))) )
                                                                            while (ex_L76521.hasNext) {
                                                                                val sol_L76521 = ex_L76521.next
                                                                                if(sol_L76521.result) {
                                                                                vars += ("Plan" -> sol_L76521.bindings("L76521").asInstanceOf[GenericTerm])
                                                                                                    PrimitiveAction.execute(PrimitiveAction.Parameters(() => println( (StringTerm("  Processing plan: ") + vars("Plan")) )))
                                                                                                    adopt_achievement_update_integrity_2.execute(Parameters(List( vars("A") , vars("Plan")  )))

                                                                                }
                                                                            }
                                                                        vars -= ("Plan")

                                                   }
                                               }
                                           vars -= ("A")


                     }


      }

      object adopt_achievement_update_integrity_2 extends IGoal {

        def execute(params: Parameters) (implicit executionContext: ExecutionContext) : Unit = {
         var vars = VarMap()

         vars("Self").bind_to(StringTerm(executionContext.name))
         vars("Source").bind_to(StringTerm(executionContext.src.name))
         vars("Parent").bind_to(StringTerm(executionContext.parent.name))






                 //plan 0 start

                         vars.clear()
                         vars("Self").bind_to(StringTerm(executionContext.name))
                         vars("Source").bind_to(StringTerm(executionContext.src.name))
                         vars("Parent").bind_to(StringTerm(executionContext.parent.name))
                         vars +=(   "A" -> params.l_params(0))
                          vars +=(   "Plan" -> params.l_params(1))

                             plan0(vars)
                             return
                          // plan 0 end


             executionContext.src.asInstanceOf[AkkaMessageSource].address() ! IntentionErrorMessage(NoApplicablePlanMessage(),AkkaMessageSource(executionContext.agent.self))

        }


                      def plan0(vars: VarMap)(implicit executionContext: ExecutionContext): Unit = {

                                          PrimitiveAction.execute(PrimitiveAction.Parameters(() => println( ( ( (StringTerm("Calling update_integrity for ") + vars("A"))  + StringTerm(" and plan "))  + vars("Plan")) )))
                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("-", StructTerm("sum",Seq[GenericTerm](vars("A"),vars("Plan"),vars("_")))),GoalParser)
                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("+", StructTerm("sum",Seq[GenericTerm](vars("A"),vars("Plan"),DoubleTerm(0.0)))),GoalParser)
                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("-", StructTerm("dMax",Seq[GenericTerm](vars("A"),vars("Plan"),vars("_")))),GoalParser)
                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("+", StructTerm("dMax",Seq[GenericTerm](vars("A"),vars("Plan"),DoubleTerm(0.0)))),GoalParser)
                                          PrimitiveAction.execute(PrimitiveAction.Parameters(() => println( ( ( ( (StringTerm("-------Update the integrity of Agent ") + vars("A"))  + StringTerm(" for plan "))  + vars("Plan"))  + StringTerm("------")) )))
                                               val ex_L64971 = executionContext.beliefBase.bufferedQuery( StructTerm("principle",Seq[GenericTerm](vars("Plan"),vars("L64971"),vars("P"))) )
                                               while (ex_L64971.hasNext) {
                                                   val sol_L64971 = ex_L64971.next
                                                   if(sol_L64971.result) {
                                                   vars += ("X" -> sol_L64971.bindings("L64971").asInstanceOf[GenericTerm])
                                                                       adopt_achievement_get_principle_intention_3.execute(Parameters(List( vars("A") , vars("Plan") , vars("X")  )))
                                                                       adopt_achievement_distanceMax_3.execute(Parameters(List( vars("A") , vars("Plan") , IntTerm(1)  )))

                                                   }
                                               }
                                           vars -= ("X")
                                          adopt_achievement_normalizedDistance_2.execute(Parameters(List( vars("A") , vars("Plan")  )))


                     }


      }

      object adopt_achievement_get_principle_intention_3 extends IGoal {

        def execute(params: Parameters) (implicit executionContext: ExecutionContext) : Unit = {
         var vars = VarMap()

         vars("Self").bind_to(StringTerm(executionContext.name))
         vars("Source").bind_to(StringTerm(executionContext.src.name))
         vars("Parent").bind_to(StringTerm(executionContext.parent.name))






                 //plan 0 start

                         vars.clear()
                         vars("Self").bind_to(StringTerm(executionContext.name))
                         vars("Source").bind_to(StringTerm(executionContext.src.name))
                         vars("Parent").bind_to(StringTerm(executionContext.parent.name))
                         vars +=(   "A" -> params.l_params(0))
                          vars +=(   "Plan" -> params.l_params(1))
                          vars +=(   "X" -> params.l_params(2))

                         val r0 = executionContext.beliefBase.query(StructTerm("missing_or_zero_value",Seq[GenericTerm](vars("A"),vars("X"),vars("Value"))))

                         if (r0.result) {
                             r0.bindings foreach { case (k, v) =>
                            // vars += (k -> v.asInstanceOf[GenericTerm])
                                      vars(k).bind_to(v)
                             }
                             plan0(vars)
                             return
                          }

                          // plan 0 end



                 //plan 1 start

                         vars.clear()
                         vars("Self").bind_to(StringTerm(executionContext.name))
                         vars("Source").bind_to(StringTerm(executionContext.src.name))
                         vars("Parent").bind_to(StringTerm(executionContext.parent.name))
                         vars +=(   "A" -> params.l_params(0))
                          vars +=(   "Plan" -> params.l_params(1))
                          vars +=(   "X" -> params.l_params(2))

                         val r1 = executionContext.beliefBase.query(StructTerm("value",Seq[GenericTerm](vars("A"),vars("X"),vars("V"))))

                         if (r1.result) {
                             r1.bindings foreach { case (k, v) =>
                            // vars += (k -> v.asInstanceOf[GenericTerm])
                                      vars(k).bind_to(v)
                             }
                             plan1(vars)
                             return
                          }

                          // plan 1 end


             executionContext.src.asInstanceOf[AkkaMessageSource].address() ! IntentionErrorMessage(NoApplicablePlanMessage(),AkkaMessageSource(executionContext.agent.self))

        }


                      def plan0(vars: VarMap)(implicit executionContext: ExecutionContext): Unit = {

                                          PrimitiveAction.execute(PrimitiveAction.Parameters(() => println( ( ( ( (StringTerm("The agent ") + vars("A"))  + StringTerm(" has no value for principle "))  + vars("X"))  + StringTerm(". Assigning default value.")) )))
                                          adopt_achievement_assign_value_2.execute(Parameters(List( vars("A") , vars("X")  )))


                     }
                      def plan1(vars: VarMap)(implicit executionContext: ExecutionContext): Unit = {

                                          PrimitiveAction.execute(PrimitiveAction.Parameters(() => println( ( ( (vars("A") + StringTerm(" intends to do "))  + vars("Plan"))  + StringTerm(".")) )))
                                          adopt_achievement_get_weight_3.execute(Parameters(List( vars("A") , vars("X") , vars("Plan")  )))
                                          adopt_achievement_distanceSum_3.execute(Parameters(List( vars("A") , vars("Plan") , vars("X")  )))


                     }


      }

      object adopt_achievement_get_weight_3 extends IGoal {

        def execute(params: Parameters) (implicit executionContext: ExecutionContext) : Unit = {
         var vars = VarMap()

         vars("Self").bind_to(StringTerm(executionContext.name))
         vars("Source").bind_to(StringTerm(executionContext.src.name))
         vars("Parent").bind_to(StringTerm(executionContext.parent.name))






                 //plan 0 start

                         vars.clear()
                         vars("Self").bind_to(StringTerm(executionContext.name))
                         vars("Source").bind_to(StringTerm(executionContext.src.name))
                         vars("Parent").bind_to(StringTerm(executionContext.parent.name))
                         vars +=(   "A" -> params.l_params(0))
                          vars +=(   "X" -> params.l_params(1))
                          vars +=(   "Plan" -> params.l_params(2))

                         val r0 = executionContext.beliefBase.query(StructTerm(",",Seq[GenericTerm](StructTerm(",",Seq[GenericTerm](StructTerm(",",Seq[GenericTerm](StructTerm(",",Seq[GenericTerm](StructTerm(",",Seq[GenericTerm](StructTerm("principle",Seq[GenericTerm](vars("Plan"),vars("X"),vars("P"))),StructTerm("value",Seq[GenericTerm](vars("A"),vars("X"),vars("Weight"))))),StructTerm("intention",Seq[GenericTerm](vars("A"),vars("X"),vars("Weight2"))))),StructTerm("is",Seq[GenericTerm](vars("D1"),StructTerm("**",Seq[GenericTerm](StructTerm("-",Seq[GenericTerm](vars("Weight"),vars("P"))),IntTerm(2))))))),StructTerm("is",Seq[GenericTerm](vars("D2"),StructTerm("**",Seq[GenericTerm](StructTerm("-",Seq[GenericTerm](vars("Weight2"),vars("P"))),IntTerm(2))))))),StructTerm("is",Seq[GenericTerm](vars("D"),StructTerm("-",Seq[GenericTerm](vars("Weight"),vars("P"))))))))

                         if (r0.result) {
                             r0.bindings foreach { case (k, v) =>
                            // vars += (k -> v.asInstanceOf[GenericTerm])
                                      vars(k).bind_to(v)
                             }
                             plan0(vars)
                             return
                          }

                          // plan 0 end



                 //plan 1 start

                         vars.clear()
                         vars("Self").bind_to(StringTerm(executionContext.name))
                         vars("Source").bind_to(StringTerm(executionContext.src.name))
                         vars("Parent").bind_to(StringTerm(executionContext.parent.name))
                         vars +=(   "A" -> params.l_params(0))
                          vars +=(   "X" -> params.l_params(1))
                          vars +=(   "Plan" -> params.l_params(2))

                         val r1 = executionContext.beliefBase.query(StructTerm(",",Seq[GenericTerm](StructTerm(",",Seq[GenericTerm](StructTerm("principle",Seq[GenericTerm](vars("Plan"),vars("X"),vars("P"))),StructTerm("value",Seq[GenericTerm](vars("A"),vars("X"),vars("Weight"))))),StructTerm("is",Seq[GenericTerm](vars("D"),StructTerm("-",Seq[GenericTerm](vars("Weight"),vars("P"))))))))

                         if (r1.result) {
                             r1.bindings foreach { case (k, v) =>
                            // vars += (k -> v.asInstanceOf[GenericTerm])
                                      vars(k).bind_to(v)
                             }
                             plan1(vars)
                             return
                          }

                          // plan 1 end



                 //plan 2 start

                         vars.clear()
                         vars("Self").bind_to(StringTerm(executionContext.name))
                         vars("Source").bind_to(StringTerm(executionContext.src.name))
                         vars("Parent").bind_to(StringTerm(executionContext.parent.name))
                         vars +=(   "A" -> params.l_params(0))
                          vars +=(   "X" -> params.l_params(1))
                          vars +=(   "Plan" -> params.l_params(2))

                         val r2 = executionContext.beliefBase.query(StructTerm("principle",Seq[GenericTerm](vars("Plan"),vars("X"),vars("P"))))

                         if (r2.result) {
                             r2.bindings foreach { case (k, v) =>
                            // vars += (k -> v.asInstanceOf[GenericTerm])
                                      vars(k).bind_to(v)
                             }
                             plan2(vars)
                             return
                          }

                          // plan 2 end



                 //plan 3 start

                         vars.clear()
                         vars("Self").bind_to(StringTerm(executionContext.name))
                         vars("Source").bind_to(StringTerm(executionContext.src.name))
                         vars("Parent").bind_to(StringTerm(executionContext.parent.name))
                         vars +=(   "A" -> params.l_params(0))
                          vars +=(   "X" -> params.l_params(1))
                          vars +=(   "Plan" -> params.l_params(2))

                         val r3 = executionContext.beliefBase.query(StructTerm(",",Seq[GenericTerm](StructTerm(",",Seq[GenericTerm](StructTerm(",",Seq[GenericTerm](StructTerm("principle",Seq[GenericTerm](vars("Plan"),vars("P"),vars("X1"))),StructTerm("value",Seq[GenericTerm](vars("A"),vars("P"),vars("X2"))))),StructTerm("insincere",Seq[GenericTerm](vars("A"),vars("P"),vars("X3"))))),StructTerm("is",Seq[GenericTerm](vars("D"),StructTerm("-",Seq[GenericTerm](vars("X1"),vars("X2"))))))))

                         if (r3.result) {
                             r3.bindings foreach { case (k, v) =>
                            // vars += (k -> v.asInstanceOf[GenericTerm])
                                      vars(k).bind_to(v)
                             }
                             plan3(vars)
                             return
                          }

                          // plan 3 end



                 //plan 4 start

                         vars.clear()
                         vars("Self").bind_to(StringTerm(executionContext.name))
                         vars("Source").bind_to(StringTerm(executionContext.src.name))
                         vars("Parent").bind_to(StringTerm(executionContext.parent.name))
                         vars +=(   "A" -> params.l_params(0))
                          vars +=(   "X" -> params.l_params(1))
                          vars +=(   "Plan" -> params.l_params(2))

                         val r4 = executionContext.beliefBase.query(StructTerm(",",Seq[GenericTerm](StructTerm(",",Seq[GenericTerm](StructTerm("principle",Seq[GenericTerm](vars("Plan"),vars("P"),vars("X1"))),StructTerm("value",Seq[GenericTerm](vars("A"),vars("P"),vars("X2"))))),StructTerm("is",Seq[GenericTerm](vars("D"),StructTerm("-",Seq[GenericTerm](vars("X1"),vars("X2"))))))))

                         if (r4.result) {
                             r4.bindings foreach { case (k, v) =>
                            // vars += (k -> v.asInstanceOf[GenericTerm])
                                      vars(k).bind_to(v)
                             }
                             plan4(vars)
                             return
                          }

                          // plan 4 end


             executionContext.src.asInstanceOf[AkkaMessageSource].address() ! IntentionErrorMessage(NoApplicablePlanMessage(),AkkaMessageSource(executionContext.agent.self))

        }


                      def plan0(vars: VarMap)(implicit executionContext: ExecutionContext): Unit = {

                                          if(( (vars("D1") > vars("D2")) ).holds) {
                                                                   BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("-", StructTerm("intention",Seq[GenericTerm](vars("A"),vars("X"),vars("Weight2")))),GoalParser)
                                                                   BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("+", StructTerm("intention",Seq[GenericTerm](vars("A"),vars("X"),vars("Weight")))),GoalParser)
                                                                   BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("-", StructTerm("insincere",Seq[GenericTerm](vars("A"),vars("X"),vars("_")))),GoalParser)
                                                                   BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("+", StructTerm("insincere",Seq[GenericTerm](vars("A"),vars("X"),vars("D")))),GoalParser)
                                                                  PrimitiveAction.execute(PrimitiveAction.Parameters(() => println( ( ( ( ( ( (StringTerm("The intentions of ") + vars("A"))  + StringTerm(" show that they deviate "))  + vars("D"))  + StringTerm(" from what I believed about how they value "))  + vars("X"))  + StringTerm(".")) )))

                                          }


                     }
                      def plan1(vars: VarMap)(implicit executionContext: ExecutionContext): Unit = {

                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("-", StructTerm("intention",Seq[GenericTerm](vars("A"),vars("X"),vars("_")))),GoalParser)
                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("+", StructTerm("intention",Seq[GenericTerm](vars("A"),vars("X"),vars("Weight")))),GoalParser)
                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("-", StructTerm("insincere",Seq[GenericTerm](vars("A"),vars("X"),vars("_")))),GoalParser)
                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("+", StructTerm("insincere",Seq[GenericTerm](vars("A"),vars("X"),vars("D")))),GoalParser)
                                          PrimitiveAction.execute(PrimitiveAction.Parameters(() => println( ( ( ( ( ( (StringTerm("The intentions of ") + vars("A"))  + StringTerm(" show that they deviate "))  + vars("D"))  + StringTerm(" from what I believed about how they value "))  + vars("X"))  + StringTerm(".")) )))


                     }
                      def plan2(vars: VarMap)(implicit executionContext: ExecutionContext): Unit = {

                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("-", StructTerm("insincere",Seq[GenericTerm](vars("A"),vars("X"),vars("_")))),GoalParser)
                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("+", StructTerm("insincere",Seq[GenericTerm](vars("A"),vars("X"),IntTerm(0)))),GoalParser)
                                          PrimitiveAction.execute(PrimitiveAction.Parameters(() => println( ( ( ( (StringTerm("The intentions of ") + vars("A"))  + StringTerm(" do not tell me anything about how they value principle "))  + vars("X"))  + StringTerm(". Their behaviour does not influence how I view their integrity.")) )))
                                          adopt_achievement_assign_intention_3.execute(Parameters(List( vars("A") , vars("X") , vars("Plan")  )))


                     }
                      def plan3(vars: VarMap)(implicit executionContext: ExecutionContext): Unit = {

                                          if(( (vars("D") > vars("X3")) ).holds) {
                                                                   BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("-", StructTerm("intention",Seq[GenericTerm](vars("Agent"),vars("P"),vars("_")))),GoalParser)
                                                                   BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("+", StructTerm("intention",Seq[GenericTerm](vars("Agent"),vars("P"),vars("Weight")))),GoalParser)
                                                                   BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("-", StructTerm("insincere",Seq[GenericTerm](vars("Agent"),vars("P"),vars("X3")))),GoalParser)
                                                                   BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("+", StructTerm("insincere",Seq[GenericTerm](vars("Agent"),vars("P"),vars("D")))),GoalParser)
                                                                  PrimitiveAction.execute(PrimitiveAction.Parameters(() => println( ( ( ( ( ( (StringTerm("The intentions of ") + vars("A"))  + StringTerm(" show that they deviate "))  + vars("D"))  + StringTerm(" from what I believed about how they value "))  + vars("P"))  + StringTerm(".")) )))

                                          }


                     }
                      def plan4(vars: VarMap)(implicit executionContext: ExecutionContext): Unit = {

                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("-", StructTerm("insencere",Seq[GenericTerm](vars("A"),vars("P"),vars("_")))),GoalParser)
                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("+", StructTerm("insincere",Seq[GenericTerm](vars("A"),vars("P"),vars("D")))),GoalParser)
                                          PrimitiveAction.execute(PrimitiveAction.Parameters(() => println( ( ( ( ( ( (StringTerm("The intentions of ") + vars("A"))  + StringTerm(" show that they deviate "))  + vars("D"))  + StringTerm(" from what I believed about how they value "))  + vars("P"))  + StringTerm(".")) )))


                     }


      }

      object adopt_achievement_assign_intention_3 extends IGoal {

        def execute(params: Parameters) (implicit executionContext: ExecutionContext) : Unit = {
         var vars = VarMap()

         vars("Self").bind_to(StringTerm(executionContext.name))
         vars("Source").bind_to(StringTerm(executionContext.src.name))
         vars("Parent").bind_to(StringTerm(executionContext.parent.name))






                 //plan 0 start

                         vars.clear()
                         vars("Self").bind_to(StringTerm(executionContext.name))
                         vars("Source").bind_to(StringTerm(executionContext.src.name))
                         vars("Parent").bind_to(StringTerm(executionContext.parent.name))
                         vars +=(   "A" -> params.l_params(0))
                          vars +=(   "X" -> params.l_params(1))
                          vars +=(   "Plan" -> params.l_params(2))

                         val r0 = executionContext.beliefBase.query(StructTerm(",",Seq[GenericTerm](StructTerm(",",Seq[GenericTerm](StructTerm(",",Seq[GenericTerm](StructTerm(",",Seq[GenericTerm](StructTerm("trustor",Seq[GenericTerm](vars("B"))),StructTerm("principle",Seq[GenericTerm](vars("Plan"),vars("X"),vars("P"))))),StructTerm("relationship",Seq[GenericTerm](vars("B"),vars("A"),vars("Type"))))),StructTerm("weight_relationship",Seq[GenericTerm](vars("Type"),vars("W"))))),StructTerm("relationship_strength",Seq[GenericTerm](vars("B"),vars("A"),vars("Strength"))))))

                         if (r0.result) {
                             r0.bindings foreach { case (k, v) =>
                            // vars += (k -> v.asInstanceOf[GenericTerm])
                                      vars(k).bind_to(v)
                             }
                             plan0(vars)
                             return
                          }

                          // plan 0 end



                 //plan 1 start

                         vars.clear()
                         vars("Self").bind_to(StringTerm(executionContext.name))
                         vars("Source").bind_to(StringTerm(executionContext.src.name))
                         vars("Parent").bind_to(StringTerm(executionContext.parent.name))
                         vars +=(   "A" -> params.l_params(0))
                          vars +=(   "X" -> params.l_params(1))
                          vars +=(   "Plan" -> params.l_params(2))

                         val r1 = executionContext.beliefBase.query(StructTerm("principle",Seq[GenericTerm](vars("Plan"),vars("X"),vars("P"))))

                         if (r1.result) {
                             r1.bindings foreach { case (k, v) =>
                            // vars += (k -> v.asInstanceOf[GenericTerm])
                                      vars(k).bind_to(v)
                             }
                             plan1(vars)
                             return
                          }

                          // plan 1 end


             executionContext.src.asInstanceOf[AkkaMessageSource].address() ! IntentionErrorMessage(NoApplicablePlanMessage(),AkkaMessageSource(executionContext.agent.self))

        }


                      def plan0(vars: VarMap)(implicit executionContext: ExecutionContext): Unit = {

                                           vars += ("DefaultIntention" ->  (vars("Strength") * vars("W")) )
                                          PrimitiveAction.execute(PrimitiveAction.Parameters(() => println( ( ( ( ( ( ( (StringTerm("Assigning intention for ") + vars("A"))  + StringTerm(" on "))  + vars("X"))  + StringTerm(" based on relationship with "))  + vars("B"))  + StringTerm(": "))  + vars("DefaultIntention")) )))
                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("-", StructTerm("intention",Seq[GenericTerm](vars("A"),vars("X"),vars("_")))),GoalParser)
                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("+", StructTerm("intention",Seq[GenericTerm](vars("A"),vars("X"),vars("DefaultIntention")))),GoalParser)


                     }
                      def plan1(vars: VarMap)(implicit executionContext: ExecutionContext): Unit = {

                                          PrimitiveAction.execute(PrimitiveAction.Parameters(() => println( ( ( ( ( (StringTerm("Assigning intention for ") + vars("A"))  + StringTerm(" on "))  + vars("X"))  + StringTerm(" based on principle value: "))  + vars("P")) )))
                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("-", StructTerm("intention",Seq[GenericTerm](vars("A"),vars("X"),vars("_")))),GoalParser)
                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("+", StructTerm("intention",Seq[GenericTerm](vars("A"),vars("X"),vars("P")))),GoalParser)


                     }


      }

      object adopt_achievement_assign_value_2 extends IGoal {

        def execute(params: Parameters) (implicit executionContext: ExecutionContext) : Unit = {
         var vars = VarMap()

         vars("Self").bind_to(StringTerm(executionContext.name))
         vars("Source").bind_to(StringTerm(executionContext.src.name))
         vars("Parent").bind_to(StringTerm(executionContext.parent.name))






                 //plan 0 start

                         vars.clear()
                         vars("Self").bind_to(StringTerm(executionContext.name))
                         vars("Source").bind_to(StringTerm(executionContext.src.name))
                         vars("Parent").bind_to(StringTerm(executionContext.parent.name))
                         vars +=(   "A" -> params.l_params(0))
                          vars +=(   "X" -> params.l_params(1))

                         val r0 = executionContext.beliefBase.query(StructTerm(",",Seq[GenericTerm](StructTerm(",",Seq[GenericTerm](StructTerm(",",Seq[GenericTerm](StructTerm(",",Seq[GenericTerm](StructTerm("principle",Seq[GenericTerm](vars("Plan"),vars("X"),vars("P"))),StructTerm("trustor",Seq[GenericTerm](vars("B"))))),StructTerm("relationship",Seq[GenericTerm](vars("B"),vars("A"),vars("Type"))))),StructTerm("weight_relationship",Seq[GenericTerm](vars("Type"),vars("W"))))),StructTerm("relationship_strength",Seq[GenericTerm](vars("B"),vars("A"),vars("Strength"))))))

                         if (r0.result) {
                             r0.bindings foreach { case (k, v) =>
                            // vars += (k -> v.asInstanceOf[GenericTerm])
                                      vars(k).bind_to(v)
                             }
                             plan0(vars)
                             return
                          }

                          // plan 0 end



                 //plan 1 start

                         vars.clear()
                         vars("Self").bind_to(StringTerm(executionContext.name))
                         vars("Source").bind_to(StringTerm(executionContext.src.name))
                         vars("Parent").bind_to(StringTerm(executionContext.parent.name))
                         vars +=(   "A" -> params.l_params(0))
                          vars +=(   "X" -> params.l_params(1))

                         val r1 = executionContext.beliefBase.query(StructTerm("principle",Seq[GenericTerm](vars("Plan"),vars("X"),vars("P"))))

                         if (r1.result) {
                             r1.bindings foreach { case (k, v) =>
                            // vars += (k -> v.asInstanceOf[GenericTerm])
                                      vars(k).bind_to(v)
                             }
                             plan1(vars)
                             return
                          }

                          // plan 1 end


             executionContext.src.asInstanceOf[AkkaMessageSource].address() ! IntentionErrorMessage(NoApplicablePlanMessage(),AkkaMessageSource(executionContext.agent.self))

        }


                      def plan0(vars: VarMap)(implicit executionContext: ExecutionContext): Unit = {

                                           vars += ("DefaultValue" ->  (vars("Strength") * vars("W")) )
                                          PrimitiveAction.execute(PrimitiveAction.Parameters(() => println( ( ( ( ( ( ( (StringTerm("Assigning value for ") + vars("A"))  + StringTerm(" on "))  + vars("X"))  + StringTerm(" based on relationship with "))  + vars("B"))  + StringTerm(": "))  + vars("DefaultValue")) )))
                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("-", StructTerm("value",Seq[GenericTerm](vars("A"),vars("X"),IntTerm(0)))),GoalParser)
                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("+", StructTerm("value",Seq[GenericTerm](vars("A"),vars("X"),vars("DefaultValue")))),GoalParser)


                     }
                      def plan1(vars: VarMap)(implicit executionContext: ExecutionContext): Unit = {

                                          PrimitiveAction.execute(PrimitiveAction.Parameters(() => println( ( ( (StringTerm("Assigning default value 0.5 for ") + vars("A"))  + StringTerm(" on "))  + vars("X")) )))
                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("-", StructTerm("value",Seq[GenericTerm](vars("A"),vars("X"),IntTerm(0)))),GoalParser)
                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("+", StructTerm("value",Seq[GenericTerm](vars("A"),vars("X"),DoubleTerm(0.5)))),GoalParser)


                     }


      }

      object adopt_achievement_distanceSum_3 extends IGoal {

        def execute(params: Parameters) (implicit executionContext: ExecutionContext) : Unit = {
         var vars = VarMap()

         vars("Self").bind_to(StringTerm(executionContext.name))
         vars("Source").bind_to(StringTerm(executionContext.src.name))
         vars("Parent").bind_to(StringTerm(executionContext.parent.name))






                 //plan 0 start

                         vars.clear()
                         vars("Self").bind_to(StringTerm(executionContext.name))
                         vars("Source").bind_to(StringTerm(executionContext.src.name))
                         vars("Parent").bind_to(StringTerm(executionContext.parent.name))
                         vars +=(   "A" -> params.l_params(0))
                          vars +=(   "Plan" -> params.l_params(1))
                          vars +=(   "X" -> params.l_params(2))

                         val r0 = executionContext.beliefBase.query(StructTerm(",",Seq[GenericTerm](StructTerm(",",Seq[GenericTerm](StructTerm(",",Seq[GenericTerm](StructTerm(",",Seq[GenericTerm](StructTerm(",",Seq[GenericTerm](StructTerm("principle",Seq[GenericTerm](vars("Plan"),vars("X"),vars("P"))),StructTerm("intention",Seq[GenericTerm](vars("A"),vars("X"),vars("I"))))),StructTerm("weight",Seq[GenericTerm](vars("X"),vars("W"))))),StructTerm("sum",Seq[GenericTerm](vars("A"),vars("Plan"),vars("CurrentSum"))))),StructTerm("is",Seq[GenericTerm](vars("D"),StructTerm("*",Seq[GenericTerm](vars("W"),StructTerm("**",Seq[GenericTerm](StructTerm("-",Seq[GenericTerm](vars("P"),vars("I"))),IntTerm(2))))))))),StructTerm("is",Seq[GenericTerm](vars("NewSum"),StructTerm("+",Seq[GenericTerm](vars("CurrentSum"),vars("D"))))))))

                         if (r0.result) {
                             r0.bindings foreach { case (k, v) =>
                            // vars += (k -> v.asInstanceOf[GenericTerm])
                                      vars(k).bind_to(v)
                             }
                             plan0(vars)
                             return
                          }

                          // plan 0 end


             executionContext.src.asInstanceOf[AkkaMessageSource].address() ! IntentionErrorMessage(NoApplicablePlanMessage(),AkkaMessageSource(executionContext.agent.self))

        }


                      def plan0(vars: VarMap)(implicit executionContext: ExecutionContext): Unit = {

                                          PrimitiveAction.execute(PrimitiveAction.Parameters(() => println( ( ( ( ( ( (StringTerm("the new sum of distances is :") + vars("NewSum"))  + StringTerm(" in plan "))  + vars("Plan"))  + StringTerm(" is: "))  + vars("NewSum"))  + StringTerm(".")) )))
                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("-", StructTerm("sum",Seq[GenericTerm](vars("A"),vars("Plan"),vars("CurrentSum")))),GoalParser)
                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("+", StructTerm("sum",Seq[GenericTerm](vars("A"),vars("Plan"),vars("NewSum")))),GoalParser)


                     }


      }

      object adopt_achievement_distanceMax_3 extends IGoal {

        def execute(params: Parameters) (implicit executionContext: ExecutionContext) : Unit = {
         var vars = VarMap()

         vars("Self").bind_to(StringTerm(executionContext.name))
         vars("Source").bind_to(StringTerm(executionContext.src.name))
         vars("Parent").bind_to(StringTerm(executionContext.parent.name))






                 //plan 0 start

                         vars.clear()
                         vars("Self").bind_to(StringTerm(executionContext.name))
                         vars("Source").bind_to(StringTerm(executionContext.src.name))
                         vars("Parent").bind_to(StringTerm(executionContext.parent.name))
                         vars +=(   "A" -> params.l_params(0))
                          vars +=(   "Plan" -> params.l_params(1))
                          vars +=(   "M" -> params.l_params(2))

                         val r0 = executionContext.beliefBase.query(StructTerm(",",Seq[GenericTerm](StructTerm("dMax",Seq[GenericTerm](vars("A"),vars("Plan"),vars("CurrentDMax"))),StructTerm("is",Seq[GenericTerm](vars("NewCurrentDMax"),StructTerm("+",Seq[GenericTerm](vars("CurrentDMax"),vars("M"))))))))

                         if (r0.result) {
                             r0.bindings foreach { case (k, v) =>
                            // vars += (k -> v.asInstanceOf[GenericTerm])
                                      vars(k).bind_to(v)
                             }
                             plan0(vars)
                             return
                          }

                          // plan 0 end


             executionContext.src.asInstanceOf[AkkaMessageSource].address() ! IntentionErrorMessage(NoApplicablePlanMessage(),AkkaMessageSource(executionContext.agent.self))

        }


                      def plan0(vars: VarMap)(implicit executionContext: ExecutionContext): Unit = {

                                          PrimitiveAction.execute(PrimitiveAction.Parameters(() => println( ( (StringTerm("the new max distance is:") + vars("NewCurrentDMax"))  + StringTerm(".")) )))
                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("-", StructTerm("dMax",Seq[GenericTerm](vars("A"),vars("Plan"),vars("CurrentDMax")))),GoalParser)
                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("+", StructTerm("dMax",Seq[GenericTerm](vars("A"),vars("Plan"),vars("NewCurrentDMax")))),GoalParser)


                     }


      }

      object adopt_achievement_normalizedDistance_2 extends IGoal {

        def execute(params: Parameters) (implicit executionContext: ExecutionContext) : Unit = {
         var vars = VarMap()

         vars("Self").bind_to(StringTerm(executionContext.name))
         vars("Source").bind_to(StringTerm(executionContext.src.name))
         vars("Parent").bind_to(StringTerm(executionContext.parent.name))






                 //plan 0 start

                         vars.clear()
                         vars("Self").bind_to(StringTerm(executionContext.name))
                         vars("Source").bind_to(StringTerm(executionContext.src.name))
                         vars("Parent").bind_to(StringTerm(executionContext.parent.name))
                         vars +=(   "A" -> params.l_params(0))
                          vars +=(   "Plan" -> params.l_params(1))

                         val r0 = executionContext.beliefBase.query(StructTerm(",",Seq[GenericTerm](StructTerm(",",Seq[GenericTerm](StructTerm("sum",Seq[GenericTerm](vars("A"),vars("Plan"),vars("D"))),StructTerm("threshold",Seq[GenericTerm](vars("T"))))),StructTerm("dMax",Seq[GenericTerm](vars("A"),vars("Plan"),vars("M"))))))

                         if (r0.result) {
                             r0.bindings foreach { case (k, v) =>
                            // vars += (k -> v.asInstanceOf[GenericTerm])
                                      vars(k).bind_to(v)
                             }
                             plan0(vars)
                             return
                          }

                          // plan 0 end


             executionContext.src.asInstanceOf[AkkaMessageSource].address() ! IntentionErrorMessage(NoApplicablePlanMessage(),AkkaMessageSource(executionContext.agent.self))

        }


                      def plan0(vars: VarMap)(implicit executionContext: ExecutionContext): Unit = {

                                           vars += ("Alpha" ->  (IntTerm(1) -  (nl.uva.sqrt.RootCalculator.calculateRoot(vars("D"),IntTerm(2)) / vars("M")) ) )
                                          if(( (vars("Alpha") > vars("T")) ).holds) {
                                                                  PrimitiveAction.execute(PrimitiveAction.Parameters(() => println( ( ( ( ( ( (StringTerm("I think the integrity of ") + vars("A"))  + StringTerm(" is: "))  + vars("Alpha"))  + StringTerm(". That is at least "))  + vars("T"))  + StringTerm(" so I consider them integer.")) )))

                                          }
                                           else {
                                                                  PrimitiveAction.execute(PrimitiveAction.Parameters(() => println( ( ( ( ( ( (StringTerm("I think the integrity of ") + vars("A"))  + StringTerm(" is: "))  + vars("Alpha"))  + StringTerm(". That is lower than "))  + vars("T"))  + StringTerm(" so I consider them not integer.")) )))

                                           }
                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("-", StructTerm("sum",Seq[GenericTerm](vars("A"),vars("Plan"),vars("D")))),GoalParser)
                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("+", StructTerm("sum",Seq[GenericTerm](vars("A"),vars("Plan"),DoubleTerm(0.0)))),GoalParser)
                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("-", StructTerm("dMax",Seq[GenericTerm](vars("A"),vars("Plan"),vars("M")))),GoalParser)
                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("+", StructTerm("dMax",Seq[GenericTerm](vars("A"),vars("Plan"),DoubleTerm(0.0)))),GoalParser)
                                          adopt_achievement_renew_info_3.execute(Parameters(List( vars("A") , vars("Plan") , vars("Alpha")  )))


                     }


      }

      object adopt_achievement_renew_info_3 extends IGoal {

        def execute(params: Parameters) (implicit executionContext: ExecutionContext) : Unit = {
         var vars = VarMap()

         vars("Self").bind_to(StringTerm(executionContext.name))
         vars("Source").bind_to(StringTerm(executionContext.src.name))
         vars("Parent").bind_to(StringTerm(executionContext.parent.name))






                 //plan 0 start

                         vars.clear()
                         vars("Self").bind_to(StringTerm(executionContext.name))
                         vars("Source").bind_to(StringTerm(executionContext.src.name))
                         vars("Parent").bind_to(StringTerm(executionContext.parent.name))
                         vars +=(   "A" -> params.l_params(0))
                          vars +=(   "Plan" -> params.l_params(1))
                          vars +=(   "Integrity" -> params.l_params(2))

                         val r0 = executionContext.beliefBase.query(StructTerm(",",Seq[GenericTerm](StructTerm(",",Seq[GenericTerm](StructTerm("integrity",Seq[GenericTerm](vars("A"),vars("Plan"),vars("OldIntegrity"))),StructTerm("decision_maker_agent",Seq[GenericTerm](vars("DMAgent"))))),StructTerm("trutsworthiness_provider_agent",Seq[GenericTerm](vars("Tagent"))))))

                         if (r0.result) {
                             r0.bindings foreach { case (k, v) =>
                            // vars += (k -> v.asInstanceOf[GenericTerm])
                                      vars(k).bind_to(v)
                             }
                             plan0(vars)
                             return
                          }

                          // plan 0 end



                 //plan 1 start

                         vars.clear()
                         vars("Self").bind_to(StringTerm(executionContext.name))
                         vars("Source").bind_to(StringTerm(executionContext.src.name))
                         vars("Parent").bind_to(StringTerm(executionContext.parent.name))
                         vars +=(   "A" -> params.l_params(0))
                          vars +=(   "Plan" -> params.l_params(1))
                          vars +=(   "Integrity" -> params.l_params(2))

                         val r1 = executionContext.beliefBase.query(StructTerm(",",Seq[GenericTerm](StructTerm("decision_maker_agent",Seq[GenericTerm](vars("DMAgent"))),StructTerm("trutsworthiness_provider_agent",Seq[GenericTerm](vars("Tagent"))))))

                         if (r1.result) {
                             r1.bindings foreach { case (k, v) =>
                            // vars += (k -> v.asInstanceOf[GenericTerm])
                                      vars(k).bind_to(v)
                             }
                             plan1(vars)
                             return
                          }

                          // plan 1 end


             executionContext.src.asInstanceOf[AkkaMessageSource].address() ! IntentionErrorMessage(NoApplicablePlanMessage(),AkkaMessageSource(executionContext.agent.self))

        }


                      def plan0(vars: VarMap)(implicit executionContext: ExecutionContext): Unit = {

                                          PrimitiveAction.execute(PrimitiveAction.Parameters(() => println( ( ( ( ( ( (StringTerm("I have updated the integrity of ") + vars("A"))  + StringTerm(" to "))  + vars("Integrity"))  + StringTerm(". Old integrity was: "))  + vars("OldIntegrity"))  + StringTerm(".")) )))
                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("-", StructTerm("integrity",Seq[GenericTerm](vars("A"),vars("Plan"),vars("OldIntegrity")))),GoalParser)
                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("+", StructTerm("integrity",Seq[GenericTerm](vars("A"),vars("Plan"),vars("Integrity")))),GoalParser)
                                          PrimitiveAction.execute(PrimitiveAction.Parameters(() => coms.inform(vars("DMAgent"),StructTerm("integrity",Seq[GenericTerm](vars("A"),vars("Plan"),vars("Integrity"))))))
                                          PrimitiveAction.execute(PrimitiveAction.Parameters(() => coms.inform(vars("Tagent"),StructTerm("integrity",Seq[GenericTerm](vars("A"),vars("Plan"),vars("Integrity"))))))


                     }
                      def plan1(vars: VarMap)(implicit executionContext: ExecutionContext): Unit = {

                                          PrimitiveAction.execute(PrimitiveAction.Parameters(() => println( ( ( ( (StringTerm("I have updated the integrity of ") + vars("A"))  + StringTerm(" to "))  + vars("Integrity"))  + StringTerm(".")) )))
                                           BeliefUpdateAction.execute(BeliefUpdateAction.Parameters("+", StructTerm("integrity",Seq[GenericTerm](vars("A"),vars("Integrity")))),GoalParser)
                                          PrimitiveAction.execute(PrimitiveAction.Parameters(() => coms.inform(vars("DMAgent"),StructTerm("integrity",Seq[GenericTerm](vars("A"),vars("Plan"),vars("Integrity"))))))
                                          PrimitiveAction.execute(PrimitiveAction.Parameters(() => coms.inform(vars("Tagent"),StructTerm("integrity",Seq[GenericTerm](vars("A"),vars("Plan"),vars("Integrity"))))))


                     }


      }





 }
object integrity_companion { 
   def create() = new integrity().agentBuilder 
   def create(in_coms : AgentCommunicationLayer) = new integrity(coms = in_coms).agentBuilder 
   def create(in_beliefBaseFactory: IBeliefBaseFactory) = new integrity(beliefBaseFactory = in_beliefBaseFactory).agentBuilder 
   def create(in_coms : AgentCommunicationLayer, in_beliefBaseFactory: IBeliefBaseFactory) = new integrity(coms = in_coms, beliefBaseFactory = in_beliefBaseFactory).agentBuilder 
} 
